package in.rupam.creditCard.mapper;

import in.rupam.creditCard.dto.CreditCardResponseDto;
import in.rupam.creditCard.models.CreditCard;

public class CreditCardMapper {
    public static CreditCardResponseDto creditCardToCreditCardResponseDto(CreditCard creditCard, CreditCardResponseDto cardResponseDto){
        cardResponseDto.setCardNumber(creditCard.getCardNumber());
        cardResponseDto.setCustomerMobileNumber(creditCard.getCustomerMobileNumber());
        cardResponseDto.setValidTill(creditCard.getValidTill());
        cardResponseDto.setCvv(creditCard.getCvv());
        cardResponseDto.setCardType(creditCard.getCardType());
        cardResponseDto.setNetwork(creditCard.getNetwork());
        cardResponseDto.setCardLimit(creditCard.getCardLimit());
        cardResponseDto.setPrevMonthDue(creditCard.getPrevMonthDue());
        cardResponseDto.setCurrentAvailableLimit(creditCard.getCurrentAvailableLimit());
        cardResponseDto.setCurrentMonthDue(creditCard.getCurrentMonthDue());
        cardResponseDto.setDueDate(creditCard.getDueDate());

        return cardResponseDto;
    }
}
