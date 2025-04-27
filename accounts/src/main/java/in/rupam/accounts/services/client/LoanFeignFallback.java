package in.rupam.accounts.services.client;

import in.rupam.accounts.dto.LoanDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoanFeignFallback implements LoansFeignClient {
    @Override
    public ResponseEntity<List<LoanDto>> getCustomerLoans(String mobileNumber) {
        return null;
    }
}
