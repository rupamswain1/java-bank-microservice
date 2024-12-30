package in.rupam.creditCard.service;

import in.rupam.creditCard.dto.CreateCreditCardDto;
import in.rupam.creditCard.dto.CreditCardResponseDto;

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
}
