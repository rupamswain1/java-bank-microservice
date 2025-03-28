package in.rupam.creditCard.controller;

import in.rupam.creditCard.constants.CreditCardConstants;
import in.rupam.creditCard.dto.CreateCreditCardDto;
import in.rupam.creditCard.dto.CreditCardResponseDto;
import in.rupam.creditCard.dto.ResponseDto;
import in.rupam.creditCard.dto.UpdatePaymentDto;
import in.rupam.creditCard.service.impl.CreditCardService;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
@Getter
@Setter
public class CreditCardController {
    @Autowired
    CreditCardService creditCardService;

    @Value("${build.version}")
    private String buildVersion;

    @Value("${creditCards.message}")
    private String message;

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

    @PutMapping("/updatePayment")
    public ResponseEntity<ResponseDto> updatePayment(@RequestBody UpdatePaymentDto updatePaymentDto){
        creditCardService.updatePayment(updatePaymentDto);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDto(CreditCardConstants.SUCCESS, HttpStatus.OK)
        );
    }

    @DeleteMapping("/deleteCard")
    public ResponseEntity<ResponseDto>  deleteCard(@RequestParam Long cardNumber){
        creditCardService.deleteCard(cardNumber);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDto(CreditCardConstants.DELETED, HttpStatus.OK)
        );
    }
    @DeleteMapping("/deleteCustomer")
    public ResponseEntity<ResponseDto> deleteCustomer(@RequestParam String customerMobileNumber){
        int deletedRecords = creditCardService.deleteByCustomerMobileNumber(customerMobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDto(deletedRecords+" "+CreditCardConstants.DELETED, HttpStatus.OK)
        );
    }

    @GetMapping("/build-info")
    public Map<String, Object> getBuildInfo(){
        return Map.of("build version",buildVersion,message,message);
    }

}
