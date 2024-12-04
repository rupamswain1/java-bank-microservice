package com.rupa.loanApplication.service;

import com.rupa.loanApplication.dto.LoanDto;

import java.util.List;

public interface ILoanService {
    /**
     *
     * @param loanDto details of loan to be added
     */
    void CreateLoan(LoanDto loanDto);

    /**
     * Returns all the loan of the customer
     * @param mobileNumber mobile number of the customer
     */
    List<LoanDto> getCustomerLoan(String mobileNumber);

    /**
     * Return loan details by Id
     * @param loanId
     */
    LoanDto getLoan(Long loanId);

    /**
     * Deletes the loan
     * @param loanId loanId
     */
    void deleteLoan(Long loanId);

    /**
     * Deletes all the loan for a customer
     * @param mobileNumber mobile number of the customer
     */
    void closeCustomerAccount (String mobileNumber);
}
