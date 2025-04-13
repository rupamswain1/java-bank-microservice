package in.rupam.accounts.dto;

import java.util.List;

public class AllCustomerDetailsDto {
    private String name;
    private String email;
    private String mobileNumber;
    private AccountDto accountDetails;
    private List<CreditCardResponseDto> creditCards;
    private List<LoanDto> loanDetails;
}
