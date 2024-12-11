package com.rupam.loanApplication.dto;

import com.rupam.loanApplication.constants.Messages;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LoanDto {
    private Long loanId;
    @NotEmpty(message = Messages.CUSTOMER_MOBILE_REQUIRED)
    @Pattern(regexp = "(^$|[0-9]{10})", message = Messages.TEN_DIGIT_LENGTH)
    private String customerMobileNumber;
    @NotNull(message="Amount is required")
    private Double amount;
    @NotNull(message = "interest rate is required")
    private float interestRate;
    @NotNull(message = "durationInMonths is required")
    private Integer durationInMonths;
    private Integer remainingDuration;
    @NotEmpty(message = "loanType is required")
    private String loanType;
    private Double emi;
    private LocalDateTime nextPaymentDate;
    private Double RemainingBalance;
}
