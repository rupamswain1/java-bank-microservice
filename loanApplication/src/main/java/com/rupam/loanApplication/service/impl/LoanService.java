package com.rupam.loanApplication.service.impl;

import com.rupam.loanApplication.dto.LoanDto;
import com.rupam.loanApplication.exceptions.ResourceNotAvailableException;
import com.rupam.loanApplication.mappers.LoanMapper;
import com.rupam.loanApplication.model.Loan;
import com.rupam.loanApplication.repository.LoanRepository;
import com.rupam.loanApplication.service.ILoanService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
@Transactional
public class LoanService implements ILoanService {
    LoanRepository loanRepository;
    /**
     * @param loanDto details of loan to be added
     */
    @Override
    public void CreateLoan(LoanDto loanDto) {
        Loan loan = new Loan();
        loan = LoanMapper.loanDtoToLoan(loanDto, new Loan());
        Random random = new Random();
        long randomNumber = 1000000000L + (long)(random.nextDouble() * 9000000000L);
        loan.setLoanId(randomNumber);
        //caluculate emi
        double monthlyInterest = loanDto.getInterestRate()/12/100;
        double emi = loanDto.getAmount()*monthlyInterest*Math.pow(1+monthlyInterest,loanDto.getDurationInMonths()) / (Math.pow(1 + monthlyInterest, loanDto.getDurationInMonths()) - 1);
        double totalAmountPayble = emi*loanDto.getDurationInMonths();
        loan.setRemainingDuration(loanDto.getDurationInMonths());
        loan.setEmi(emi);
        loan.setNextPaymentDate(LocalDateTime.now().with(Month.of(LocalDateTime.now().getMonthValue()%12+1)));
        loan.setRemainingBalance(totalAmountPayble);
        loanRepository.save(loan);
    }

    /**
     * Returns all the loan of the customer
     *
     * @param mobileNumber mobile number of the customer
     */
    @Override
    public List<LoanDto> getCustomerLoan(String mobileNumber) {
        List<Loan> loans = loanRepository.findByCustomerMobileNumber(mobileNumber).orElseThrow(
                ()->new ResourceNotAvailableException("Customer", "mobileNumber",mobileNumber)
        );
        List<LoanDto> loanList= new ArrayList<>();
        for(Loan loan:loans){
           loanList.add(LoanMapper.loanToLoanDto(loan, new LoanDto()));
        }
        return loanList;
    }

    /**
     * Return loan details by Id
     *
     * @param loanId id of loan
     */
    @Override
    public LoanDto getLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId).orElseThrow(
                ()->new ResourceNotAvailableException("Loan", "loanId", loanId)
        );
        return LoanMapper.loanToLoanDto(loan, new LoanDto());
    }

    /**
     * Deletes the loan
     *
     * @param loanId loanId
     */
    @Override
    public void deleteLoan(Long loanId) {
        Loan loan = loanRepository.findById(loanId).orElseThrow(
                ()->new ResourceNotAvailableException("Loan", "loanId", loanId)
        );
        loanRepository.deleteById(loanId);
    }

    /**
     * Deletes all the loan for a customer
     *
     * @param mobileNumber mobile number of the customer
     */
    @Override
    public int closeCustomerAccount(String mobileNumber) {
        List<Loan> loans = loanRepository.findByCustomerMobileNumber(mobileNumber).orElseThrow(
                ()->new ResourceNotAvailableException("Customer", "mobileNumber",mobileNumber)
        );
        if(!loans.isEmpty()){
            return loanRepository.removeByCustomerMobileNumber(mobileNumber);
        }
        throw new ResourceNotAvailableException("Customer", "mobileNumber",mobileNumber);
    }
}
