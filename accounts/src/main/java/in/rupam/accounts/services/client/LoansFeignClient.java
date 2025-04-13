package in.rupam.accounts.services.client;

import in.rupam.accounts.dto.LoanDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("loans")
public interface LoansFeignClient {
    @GetMapping("/api/getCustomerLoans")
    public ResponseEntity<List<LoanDto>> getCustomerLoans(@RequestParam String mobileNumber);
}
