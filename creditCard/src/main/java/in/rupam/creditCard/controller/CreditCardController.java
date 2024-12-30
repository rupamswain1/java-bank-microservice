package in.rupam.creditCard.controller;

import in.rupam.creditCard.constants.CreditCardConstants;
import in.rupam.creditCard.dto.CreateCreditCardDto;
import in.rupam.creditCard.dto.CreditCardResponseDto;
import in.rupam.creditCard.dto.ResponseDto;
import in.rupam.creditCard.service.impl.CreditCardService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@Getter
@Setter
public class CreditCardController {
    @Autowired
    CreditCardService creditCardService;
    @PostMapping(value = "/addCard",produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ResponseDto> addCard(@RequestBody CreateCreditCardDto createCreditCardDto){
        creditCardService.createCreditCard(createCreditCardDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseDto(CreditCardConstants.SUCCESS, HttpStatus.CREATED)
        );
    }

    @GetMapping("/getCustomerCards")
    public List<CreditCardResponseDto> getCardForCustomer(@RequestParam String customerMobileNumber){
        return creditCardService.getCustomerCards(customerMobileNumber);
    }

    @GetMapping("/getCard")
    public CreditCardResponseDto getCard(@RequestParam Long cardNumber){
        return creditCardService.gerCard(cardNumber);
    }

    @PutMapping("/updateDue")
    public void updateDueAmount(){

    }

    @PutMapping("/updateCardDetails")
    public void updateCardDetails(){

    }

    @DeleteMapping("/deleteCard")
    public void deleteCard(){

    }
    @DeleteMapping("/deleteCustomer")
    public void deleteCustomer(){

    }

}
