package in.rupam.accounts.services.impl;

import in.rupam.accounts.dto.CustomerDto;
import in.rupam.accounts.repository.AccountRepository;
import in.rupam.accounts.repository.CustomerRepository;
import in.rupam.accounts.services.IAccountService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class AccountService implements IAccountService {

    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;

    /**
     * @param customerDto - Cutomer DTo object
     */
    @Override
    public void createAccount(CustomerDto customerDto) {

    }
}
