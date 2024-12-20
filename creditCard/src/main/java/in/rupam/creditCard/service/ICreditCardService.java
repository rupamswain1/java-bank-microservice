package in.rupam.creditCard.service;

import in.rupam.creditCard.dto.CreateCreditCardDto;

public interface ICreditCardService {

    /**
     * Create a credit card for a customer
     * @param creditCardDto credit card details
     */
    public void createCreditCard(CreateCreditCardDto creditCardDto);
}
