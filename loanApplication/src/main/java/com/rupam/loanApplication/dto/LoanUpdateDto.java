package com.rupam.loanApplication.dto;

import com.rupam.loanApplication.constants.Messages;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Schema(
        name="Model to accept loan update request",
        description = "dto class to update loan data"
)
public class LoanUpdateDto {
    @NotNull(message = "loanId is required")
    @Min(value = 1000000000L, message = "loanId should be of min 10 digits")
    @Max(value = 9999999999L, message = "loanId should be of max 10 digits")
    @Schema(
            description = "Loan id 10 digits",
            example="1234567890"
    )
    private Long loanId;

    @NotEmpty(message = Messages.CUSTOMER_MOBILE_REQUIRED)
    @Pattern(regexp = "(^$|[0-9]{10})", message = Messages.TEN_DIGIT_LENGTH)
    @Schema(
            description = "Customer Mobile number",
            example="1234567890"
    )
    private String customerMobileNumber;

    @NotNull(message="Amount is required")
    @Schema(
            description = "Loan amount",
            example="300000"
    )
    private Double amount;

    @NotNull(message = "interest rate is required")
    @Schema(
            description = "Loan interest rate",
            example="9.5"
    )
    private float interestRate;

    @NotNull(message = "durationInMonths is required")
    @Schema(
            description = "Loan duration in months",
            example="120"
    )
    private Integer durationInMonths;
}
