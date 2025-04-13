package in.rupam.accounts.services.client;

import in.rupam.accounts.dto.LoanDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("loans")
public interface LoansFeignClient {
    public ResponseEntity<List<LoanDto>> getCustomerLoans(@RequestParam String mobileNumber);
}
