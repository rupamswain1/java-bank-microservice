package com.rupam.loanApplication.dto;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "loans")
@Getter
@Setter
public class LoanConfigDto {
    private String message;
    private String email;
}
