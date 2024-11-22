package in.rupam.accounts;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditAware")
@OpenAPIDefinition(
        info = @Info(
                title = "Accounts microservice REST API Documentation",
                description = "My bank Account microservice REST API Documentation",
                version = "v1",
                contact = @Contact(
                        name = "Rupam",
                        email = "rupamswain1@gmail.com",
                        url = "https://localhost8080"
                ),
                license = @License(
                        name = "Free",
                        url = "https://localhost8080"
                )
        ),
        externalDocs = @ExternalDocumentation(
                description = "refer readme.md"
        )
)
public class AccountsApplication {

    public static void main(String[] args) {
        SpringApplication.run(AccountsApplication.class, args);
    }

}
