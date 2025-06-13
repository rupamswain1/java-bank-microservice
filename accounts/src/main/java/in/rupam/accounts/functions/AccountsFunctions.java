package in.rupam.accounts.functions;

import in.rupam.accounts.services.IAccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.function.Consumer;

@Configuration
public class AccountsFunctions {
    private static final Logger log = LoggerFactory.getLogger(AccountsFunctions.class);

    @Bean
    public Consumer<Long> updatedCommunication(IAccountService accountService) {
        return accountNumber -> {
            log.info("Updating Communication status for the account number: " + accountNumber.toString());
            accountService.updateCommunicationStatus(accountNumber);
        };
    }
}
