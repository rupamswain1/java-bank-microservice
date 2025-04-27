package in.rupam.accounts.mapper;

import in.rupam.accounts.dto.AllCustomerDetailsDto;
import in.rupam.accounts.dto.CreditCardResponseDto;
import in.rupam.accounts.dto.LoanDto;
import in.rupam.accounts.model.Account;
import in.rupam.accounts.model.Customer;

import java.util.List;

public class CustomerDetailsMapper {
    public static AllCustomerDetailsDto mapToAllCustomerDto(Customer customer, Account account, List<LoanDto> loans, List<CreditCardResponseDto> creditCards, AllCustomerDetailsDto allCustomerDetailsDto) {
        allCustomerDetailsDto.setName(customer.getName());
        allCustomerDetailsDto.setCustomerId(customer.getCustomerId());
        allCustomerDetailsDto.setEmail(customer.getEmail());
        allCustomerDetailsDto.setMobileNumber(customer.getMobileNumber());
        allCustomerDetailsDto.setAccountDetails(account);
        if (loans != null) {
            allCustomerDetailsDto.setLoanDetails(loans);
        }
        if (creditCards != null) {
            allCustomerDetailsDto.setCreditCards(creditCards);
        }
        return allCustomerDetailsDto;
    }
}
