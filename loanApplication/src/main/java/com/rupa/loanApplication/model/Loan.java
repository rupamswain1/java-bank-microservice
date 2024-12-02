package com.rupa.loanApplication.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Loan extends BaseModel{
    @Id
    private Long loanId;

    private String customerMobileNumber;

    private Double amount;

    private float interestRate;

    private Integer durationInMonths;

    private Integer RemainingDuration;

    private String loanType;

    private Double emi;

    private LocalDateTime nextPaymentDate;

    private Double RemainingBalance;

}
