package in.rupam.creditCard.service;

import in.rupam.creditCard.dto.CreateCreditCardDto;
import in.rupam.creditCard.dto.CreditCardResponseDto;
import in.rupam.creditCard.dto.UpdatePaymentDto;

import java.util.List;

public interface ICreditCardService {

    /**
     * Create a credit card for a customer
     * @param creditCardDto credit card details
     */
    void createCreditCard(CreateCreditCardDto creditCardDto);

    /**
     *
     * @param cardNumber credit card number
     * @return credit card details
     */
    CreditCardResponseDto gerCard(Long cardNumber);

    /**
     *
     * @param customerMobileNumber
     * @return List of Credit cards
     */
   List<CreditCardResponseDto> getCustomerCards(String customerMobileNumber);

    /**
     * update card payment
     * @param updatePaymentDto accepts the payment details
     */
   void updatePayment(UpdatePaymentDto updatePaymentDto);

    /**
     * Delete the given card number
     * @param cardNumber
     */
   void deleteCard(Long cardNumber);

    /**
     * Deletes all the credit cards associated with a customer mobile number
     * @param customerMobileNumber mobile number of customer
     * @return number of deleted records
     */
   int deleteByCustomerMobileNumber(String customerMobileNumber);
}
