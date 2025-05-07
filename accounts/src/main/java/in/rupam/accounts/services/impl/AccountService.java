package in.rupam.accounts.services.impl;

import in.rupam.accounts.constants.AccountConstants;
import in.rupam.accounts.dto.AccountDto;
import in.rupam.accounts.dto.CustomerDto;
import in.rupam.accounts.exceptions.CustomerAlreadyExistsException;
import in.rupam.accounts.exceptions.ResourceNotAvailableException;
import in.rupam.accounts.mapper.AccountMapper;
import in.rupam.accounts.mapper.CustomerMapper;
import in.rupam.accounts.model.Account;
import in.rupam.accounts.model.Customer;
import in.rupam.accounts.repository.AccountRepository;
import in.rupam.accounts.repository.CustomerRepository;
import in.rupam.accounts.services.IAccountService;
import lombok.AllArgsConstructor;
import lombok.extern.flogger.Flogger;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountService implements IAccountService {
    private static final Logger logger = LoggerFactory.getLogger(AccountService.class);

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    /**
     * @param customerDto - Cutomer DTo object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapDtoToCustomer(customerDto, new Customer());
        Optional<Customer> exsitingCustomer = customerRepository.findByMobileNumber(customer.getMobileNumber());
        if (exsitingCustomer.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already exists with mobile number: " + customer.getMobileNumber());
        }
        Customer newCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(newCustomer));
    }

    /**
     * @param mobileNumber
     * @return CustomerDto with customer details
     */
    @Override
    public CustomerDto getCustomer(String mobileNumber) {
        logger.debug("getCustomer method start");
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotAvailableException("Customer", "mobileNumber", mobileNumber)
        );
        logger.debug("getting accounts");
        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotAvailableException("Customer", "mobileNumber", mobileNumber)
        );
        CustomerDto customerDto = CustomerMapper.mapCustomerToDto(customer, new CustomerDto());
        customerDto.setAccountDto(AccountMapper.mapAccountsToDto(account, new AccountDto()));
        logger.debug("getCustomer method end");
        return customerDto;
    }

    private Account createNewAccount(Customer customer) {
        Account newAccount = new Account();
        newAccount.setCustomerId(customer.getCustomerId());
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);
        newAccount.setAccountNumber(randomAccNumber);
        return newAccount;
    }

    @Override
    public boolean updateCustomer(CustomerDto customerDto) {
        AccountDto accountDto = customerDto.getAccountDto();
        Account account = accountRepository.findById(accountDto.getAccountNumber()).orElseThrow(
                () -> new ResourceNotAvailableException("Account", "accountNumber", accountDto.getAccountNumber())
        );
        Long customerId = account.getCustomerId();
        Customer customer = customerRepository.findById(account.getCustomerId()).orElseThrow(
                () -> new ResourceNotAvailableException("Customer", "accountNumber", customerId)
        );
        account = AccountMapper.mapDtoToAccount(accountDto, new Account());
        account.setCustomerId(customerId);
        Customer updatedCustomer = CustomerMapper.mapDtoToCustomer(customerDto, new Customer());
        updatedCustomer.setCustomerId(customerId);
        accountRepository.save(account);
        customerRepository.save(updatedCustomer);
        return true;
    }

    /**
     * delete customer and account related to customer
     *
     * @param mobileNumber customer's mobile number
     * @return boolean
     */
    @Override
    public boolean deleteCustomer(String mobileNumber) {
        boolean isDeleted = false;
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(
                () -> new ResourceNotAvailableException("Customer", "mobileNumber", mobileNumber)
        );
        customerRepository.deleteById(customer.getCustomerId());
        accountRepository.deleteByCustomerId(customer.getCustomerId());
        isDeleted = true;
        return isDeleted;
    }


}
