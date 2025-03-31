package in.rupam.creditCard;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditHandler")
@ConfigurationPropertiesScan
public class CreditCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(CreditCardApplication.class, args);
	}

}
