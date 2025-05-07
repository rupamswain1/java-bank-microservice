package in.rupam.creditCard.service.impl;

import in.rupam.creditCard.constants.CreditCardConstants;
import in.rupam.creditCard.dto.CreateCreditCardDto;
import in.rupam.creditCard.dto.CreditCardResponseDto;
import in.rupam.creditCard.dto.ResponseDto;
import in.rupam.creditCard.dto.UpdatePaymentDto;
import in.rupam.creditCard.exceptions.CardValidationFailedException;
import in.rupam.creditCard.exceptions.NotFoundException;
import in.rupam.creditCard.mapper.CreditCardMapper;
import in.rupam.creditCard.models.CreditCard;
import in.rupam.creditCard.repository.CreditCardRepo;
import in.rupam.creditCard.service.ICreditCardService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Service
@Getter
@Setter
@NoArgsConstructor
public class CreditCardService implements ICreditCardService {
    private static final Logger logger = LoggerFactory.getLogger(CreditCardService.class);
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
        logger.debug("getCard started");
       CreditCard creditCard = creditCardRepo.findById(cardNumber).orElseThrow(()->new NotFoundException(
               "creditCardNumber", cardNumber
        ));
        logger.debug("getCard ended");
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

    /**
     * update card payment
     *
     * @param updatePaymentDto accepts the payment details
     */
    @Override
    public void updatePayment(UpdatePaymentDto updatePaymentDto) {
        CreditCard card = creditCardRepo.findById(updatePaymentDto.getCardNumber()).orElseThrow(()->new NotFoundException(
                "creditCardNumber", updatePaymentDto.getCardNumber()
        ));
        List<String> errorFields = new ArrayList<>();
        if(card.getCvv()!=updatePaymentDto.getCvv()){
            errorFields.add("cvv");
        }
        if(card.getPin()!=updatePaymentDto.getPin()){
            errorFields.add("pin");
        }
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/yy");
        YearMonth inputYearMonth = YearMonth.parse(updatePaymentDto.getExpiry(), formatter);
        YearMonth dateYearMonth = YearMonth.of(card.getValidTill().getYear(), card.getValidTill().getMonth());
        if (!inputYearMonth.equals(dateYearMonth)) {
            errorFields.add("expiry");
        }
        if(!errorFields.isEmpty()){
            throw new CardValidationFailedException(errorFields);
        }

        card.setCurrentMonthDue(card.getCurrentMonthDue()+updatePaymentDto.getAmount());
        card.setCurrentAvailableLimit(card.getCurrentAvailableLimit()-updatePaymentDto.getAmount());
        creditCardRepo.save(card);
    }

    /**
     * Delete the given card number
     *
     * @param cardNumber
     */
    @Override
    public void deleteCard(Long cardNumber) {
        CreditCard card = creditCardRepo.findById(cardNumber).orElseThrow(()->new NotFoundException(
                "creditCardNumber", cardNumber
        ));
        creditCardRepo.delete(card);
    }

    /**
     * Deletes all the credit cards associated with a customer mobile number
     *
     * @param customerMobileNumber mobile number of customer
     * @return number of deleted records
     */
    @Override
    public int deleteByCustomerMobileNumber(String customerMobileNumber) {
        List<CreditCard> creditCards = creditCardRepo.findByCustomerMobileNumber(customerMobileNumber);
        if(creditCards.isEmpty()){
            throw new NotFoundException("customerMobileNumber", customerMobileNumber);
        }
        return creditCardRepo.deleteByCustomerMobileNUmber(customerMobileNumber);

    }


}
