package com.rupam.loanApplication;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing(auditorAwareRef = "auditHandler")
@OpenAPIDefinition(
		info = @Info(
				title = "Loan Microservice",
				description = "This is loan microservice, it keeps record of loan by customer",
				version = "v1",
				contact = @Contact(
						name = "Rupam",
						url="localhost:8090",
						email = "rupamswain1@gmail.com"
				)

		)
)
public class LoanApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoanApplication.class, args);
	}

}
