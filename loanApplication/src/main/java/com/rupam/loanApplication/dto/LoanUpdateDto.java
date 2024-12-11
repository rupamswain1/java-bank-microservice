package com.rupam.loanApplication.dto;

import com.rupam.loanApplication.constants.Messages;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public class LoanUpdateDto {
    @NotNull(message = "loanId is required")
    @Min(value = 1000000000L, message = "loanId should be of min 10 digits")
    @Max(value = 9999999999L, message = "loanId should be of max 10 digits")
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
}
