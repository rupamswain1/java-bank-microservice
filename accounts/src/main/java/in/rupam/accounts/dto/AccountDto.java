package in.rupam.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AccountDto {
    private Long accountNumber;

    private String accountType;

    private String branchAddress;
}
