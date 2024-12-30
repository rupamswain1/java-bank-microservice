package in.rupam.creditCard.service;

import in.rupam.creditCard.dto.CreateCreditCardDto;
import in.rupam.creditCard.dto.CreditCardResponseDto;

import java.util.List;

public interface ICreditCardService {

    /**
     * Create a credit card for a customer
     * @param creditCardDto credit card details
     */
    public void createCreditCard(CreateCreditCardDto creditCardDto);

    /**
     *
     * @param cardNumber credit card number
     * @return credit card details
     */
    public CreditCardResponseDto gerCard(Long cardNumber);

    /**
     *
     * @param customerMobileNumber
     * @return List of Credit cards
     */
    public List<CreditCardResponseDto> getCustomerCards(String customerMobileNumber);
}
