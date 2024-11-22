package in.rupam.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Accounts Schema",
        description = "data required to create an account"
)
public class AccountDto {
    @Schema(
            description = "10 digits Account Number",
            example = "1234567890"
    )
    @Digits(integer = 10, fraction = 0, message = "Account Number must be up to 10 digits")
    private Long accountNumber;

    @Schema(
            description = "Type of Account Current/Savings",
            example = "Current"
    )
    @NotEmpty(message = "accountType should not be empty")
    private String accountType;

    @Schema(
            description = "Branch Address",
            example = "52 Park Street"
    )
    @NotEmpty(message = "branchAddress should not be empty")
    private String branchAddress;
}
