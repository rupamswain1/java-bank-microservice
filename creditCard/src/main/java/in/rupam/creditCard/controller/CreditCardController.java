package in.rupam.creditCard.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class CreditCardController {

    @PostMapping("/addCard")
    public void addCard(){

    }

    @GetMapping("/getCustomerCards")
    public void getCardForCustomer(@RequestParam String customerMobileNumber){

    }

    @GetMapping("/getCard")
    public void getCard(@RequestParam Long cardNumber){

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
