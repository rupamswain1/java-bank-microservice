package com.rupam.loanApplication.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LoanDto {
    private String customerMobileNumber;
    private Double amount;
    private float interestRate;
    private Integer durationInMonths;
    private Integer remainingDuration;
    private String loanType;
    private Double emi;
    private LocalDateTime nextPaymentDate;
    private Double RemainingBalance;
}
