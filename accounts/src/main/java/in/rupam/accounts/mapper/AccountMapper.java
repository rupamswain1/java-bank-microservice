package in.rupam.accounts.mapper;

import in.rupam.accounts.dto.AccountDto;
import in.rupam.accounts.model.Account;

public class AccountMapper {
    public static AccountDto mapAccountsToDto(Account account, AccountDto accountDto) {
        accountDto.setAccountNumber(account.getAccountNumber());
        accountDto.setBranchAddress(account.getBranchAddress());
        accountDto.setAccountType(account.getAccountType());
        return accountDto;
    }

    public static Account mapDtoToAccount(AccountDto accountDto, Account account) {
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setBranchAddress(accountDto.getBranchAddress());
        account.setAccountType(accountDto.getAccountType());
        return account;
    }
}
