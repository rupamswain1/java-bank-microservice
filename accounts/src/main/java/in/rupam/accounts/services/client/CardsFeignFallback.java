package in.rupam.accounts.services.client;

import in.rupam.accounts.dto.CreditCardResponseDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CardsFeignFallback implements CardsFeignClient {
    @Override
    public List<CreditCardResponseDto> getCardForCustomer(String customerMobileNumber) {
        return List.of();
    }
}
