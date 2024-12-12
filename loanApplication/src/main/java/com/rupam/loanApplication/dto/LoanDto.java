package com.rupam.loanApplication.dto;

import com.rupam.loanApplication.constants.Messages;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(
        name="loan responses",
        description = "dto class to provide loan data"
)
public class LoanDto {
    @Schema(
            description = "Loan id 10 digits",
            example="1234567890"
    )
    private Long loanId;
    @NotEmpty(message = Messages.CUSTOMER_MOBILE_REQUIRED)
    @Pattern(regexp = "(^$|[0-9]{10})", message = Messages.TEN_DIGIT_LENGTH)
    @Schema(
            description = "customer mobile number 10 digits",
            example = "7894561230"
    )
    private String customerMobileNumber;
    @NotNull(message="Amount is required")
    @Schema(
            description = "loan amount",
            example="200000"
    )
    private Double amount;
    @NotNull(message = "interest rate is required")
    @Schema(
            description = "interest rate for loan",
            example = "8.5"
    )
    private float interestRate;
    @NotNull(message = "durationInMonths is required")
    @Schema(
            description = "Loan duration in months",
            example = "100"
    )
    private Integer durationInMonths;
    @Schema(
            description = "remaining loan duration in months",
            example = "80"
    )
    private Integer remainingDuration;
    @NotEmpty(message = "loanType is required")
    @Schema(
            description = "Loan type",
            example = "Car loan"
    )
    private String loanType;
    @Schema(
            description = "emi amount for loan",
            example = "24000"
    )
    private Double emi;
    @Schema(
            description = "next loan payment date",
            example = "2025-01-01"
    )
    private LocalDateTime nextPaymentDate;
    @Schema(
            description = "Remaining loan balance",
            example = "10000"
    )
    private Double RemainingBalance;
}
