package in.rupam.accounts.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "accounts")
@Getter
@Setter
public class AccountConfigDto {
    private String message;
    private String email;
}
