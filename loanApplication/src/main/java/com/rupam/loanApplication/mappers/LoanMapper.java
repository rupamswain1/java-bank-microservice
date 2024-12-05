package com.rupam.loanApplication.mappers;

import com.rupam.loanApplication.dto.LoanDto;
import com.rupam.loanApplication.model.Loan;

public class LoanMapper {
    public static Loan loanDtoToLoan(LoanDto loanDto, Loan loan){
        loan.setLoanType(loanDto.getLoanType());
        loan.setAmount(loanDto.getAmount());
        loan.setInterestRate(loanDto.getInterestRate());
        loan.setAmount(loanDto.getAmount());
        loan.setCustomerMobileNumber(loanDto.getCustomerMobileNumber());
        loan.setDurationInMonths(loanDto.getDurationInMonths());
        return loan;
    }

    public static LoanDto loanToLoanDto(Loan loan, LoanDto loanDto){
        loanDto.setCustomerMobileNumber(loan.getCustomerMobileNumber());
        loanDto.setAmount(loan.getAmount());
        loanDto.setInterestRate(loan.getInterestRate());
        loanDto.setDurationInMonths(loan.getDurationInMonths());
        loanDto.setRemainingDuration(loan.getRemainingDuration());
        loanDto.setLoanType(loan.getLoanType());
        loanDto.setEmi(loan.getEmi());
        loanDto.setNextPaymentDate(loan.getNextPaymentDate());
        loanDto.setRemainingBalance(loan.getRemainingBalance());
        return loanDto;

    }
}
