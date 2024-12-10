package com.rupam.loanApplication.repository;

import com.rupam.loanApplication.model.Loan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LoanRepository extends JpaRepository<Loan, Long> {
    Optional<List<Loan>> findByCustomerMobileNumber(String mobileNumber);

    @Modifying
    @Query(value = "DELETE FROM loan l WHERE l.customer_mobile_number = :mobileNumber", nativeQuery = true)
    int removeByCustomerMobileNumber(String mobileNumber);
}
