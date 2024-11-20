package in.rupam.accounts.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountDto {
    @Digits(integer = 10, fraction = 0, message = "Account Number must be up to 10 digits")
    private Long accountNumber;

    @NotEmpty(message = "accountType should not be empty")
    private String accountType;

    @NotEmpty(message = "branchAddress should not be empty")
    private String branchAddress;
}
