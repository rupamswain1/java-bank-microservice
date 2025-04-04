package in.rupam.creditCard.repository;

import in.rupam.creditCard.models.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface CreditCardRepo extends JpaRepository<CreditCard, Long> {

    @Query(nativeQuery = true, value = "SELECT * FROM credit_card WHERE customer_mobile_number=:customerMobileNumber")
    List<CreditCard> findByCustomerMobileNumber(@Param("customerMobileNumber") String customerMobileNumber);

    @Transactional
    @Modifying
    @Query(nativeQuery = true, value="DELETE FROM credit_card WHERE customer_mobile_number=:customerMobileNumber")
    int deleteByCustomerMobileNUmber(String customerMobileNumber);
}
