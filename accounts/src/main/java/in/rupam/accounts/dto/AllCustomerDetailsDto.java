package in.rupam.accounts.dto;

import in.rupam.accounts.model.Account;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class AllCustomerDetailsDto {
    private long customerId;
    private String name;
    private String email;
    private String mobileNumber;
    private Account accountDetails;
    private List<CreditCardResponseDto> creditCards;
    private List<LoanDto> loanDetails;
}
