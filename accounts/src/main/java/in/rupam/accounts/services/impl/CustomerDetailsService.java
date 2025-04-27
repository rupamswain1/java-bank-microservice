package in.rupam.accounts.services.impl;

import in.rupam.accounts.dto.AllCustomerDetailsDto;
import in.rupam.accounts.dto.CreditCardResponseDto;
import in.rupam.accounts.dto.LoanDto;
import in.rupam.accounts.exceptions.ResourceNotAvailableException;
import in.rupam.accounts.mapper.CustomerDetailsMapper;
import in.rupam.accounts.model.Account;
import in.rupam.accounts.model.Customer;
import in.rupam.accounts.repository.AccountRepository;
import in.rupam.accounts.repository.CustomerRepository;
import in.rupam.accounts.services.ICustomerDetailsService;
import in.rupam.accounts.services.client.CardsFeignClient;
import in.rupam.accounts.services.client.LoansFeignClient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CustomerDetailsService implements ICustomerDetailsService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;
    private CardsFeignClient cardsFeignClient;
    private LoansFeignClient loansFeignClient;

    @Override
    public AllCustomerDetailsDto getAllCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber).orElseThrow(() -> new ResourceNotAvailableException("Customer", "mobileNumber", mobileNumber));
        Account account = accountRepository.findByCustomerId(customer.getCustomerId()).orElseThrow(
                () -> new ResourceNotAvailableException("Customer", "mobileNumber", mobileNumber)
        );
        ResponseEntity<List<LoanDto>> loansResponse = loansFeignClient.getCustomerLoans(mobileNumber);
        List<LoanDto> loans = null;
        if (loansResponse != null) {
            loans = loansResponse.getBody();
        }
        List<CreditCardResponseDto> creditCards = cardsFeignClient.getCardForCustomer(mobileNumber);
        return CustomerDetailsMapper.mapToAllCustomerDto(customer, account, loans, creditCards, new AllCustomerDetailsDto());
    }


}

