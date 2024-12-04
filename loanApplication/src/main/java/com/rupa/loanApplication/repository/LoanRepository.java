package com.rupa.loanApplication.repository;

import com.rupa.loanApplication.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {
}
