package in.rupam.creditCard.service.impl;

import in.rupam.creditCard.constants.CreditCardConstants;
import in.rupam.creditCard.dto.CreateCreditCardDto;
import in.rupam.creditCard.dto.CreditCardResponseDto;
import in.rupam.creditCard.dto.ResponseDto;
import in.rupam.creditCard.exceptions.NotFoundException;
import in.rupam.creditCard.mapper.CreditCardMapper;
import in.rupam.creditCard.models.CreditCard;
import in.rupam.creditCard.repository.CreditCardRepo;
import in.rupam.creditCard.service.ICreditCardService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Getter
@Setter
@NoArgsConstructor
public class CreditCardService implements ICreditCardService {
    @Autowired
    CreditCardRepo creditCardRepo;
    /**
     * Create a credit card for a customer
     *
     * @param creditCardDto credit card details
     */
    @Override
    public void createCreditCard(CreateCreditCardDto creditCardDto) {
        CreditCard creditCard = new CreditCard();
        creditCard.setCustomerMobileNumber(creditCardDto.getCustomerMobileNumber());
        Random random = new Random();
        long randomNumber = 1000000000000000L + random.nextLong(900000000000000L);
        creditCard.setCardNumber(randomNumber);
        creditCard.setValidTill(LocalDateTime.now().plusYears(CreditCardConstants.VALID_YEARS));
        creditCard.setCvv(random.nextInt(900)+100);
        creditCard.setCardType(creditCardDto.getCardType());
        creditCard.setNetwork(creditCardDto.getNetwork());
        creditCard.setPin(random.nextInt(9000)+1000);
        creditCard.setCardLimit(CreditCardConstants.CARD_LIMIT);
        creditCard.setPrevMonthDue(0L);
        creditCard.setCurrentAvailableLimit(CreditCardConstants.CARD_LIMIT);
        creditCard.setCurrentMonthDue(0L);
        creditCard.setDueDate(LocalDateTime.now().plusMonths(1));
        creditCardRepo.save(creditCard);

    }

    /**
     * @param cardNumber credit card number
     * @return credit card details
     */
    @Override
    public CreditCardResponseDto gerCard(Long cardNumber) {
       CreditCard creditCard = creditCardRepo.findById(cardNumber).orElseThrow(()->new NotFoundException(
               "creditCardNumber", cardNumber
        ));
        return CreditCardMapper.creditCardToCreditCardResponseDto(creditCard,new CreditCardResponseDto());
    }

    /**
     * @param customerMobileNumber
     * @return List of Credit cards
     */
    @Override
    public List<CreditCardResponseDto> getCustomerCards(String customerMobileNumber) {
       List<CreditCard> creditCards = creditCardRepo.findByCustomerMobileNumber(customerMobileNumber);
       List<CreditCardResponseDto> creditCardResponses = new ArrayList<>();
       for(CreditCard card:creditCards){
           creditCardResponses.add(CreditCardMapper.creditCardToCreditCardResponseDto(card, new CreditCardResponseDto()));
       }
       return creditCardResponses;
    }


}
