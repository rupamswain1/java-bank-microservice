package in.rupam.accounts.services.client;

import in.rupam.accounts.dto.CreditCardResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("creditcards")
public interface CardsFeignClient {
    @GetMapping(value = "/api/getCustomerCards", consumes = "application/json")
    public List<CreditCardResponseDto> getCardForCustomer(@RequestParam String customerMobileNumber);
}
