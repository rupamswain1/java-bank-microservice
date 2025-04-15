package in.rupam.creditCard.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "credit-cards")
@Getter
@Setter
public class CreditCardsConfigDto {
    private String message;
    private String email;
}
