package in.rupam.accounts.controller;

import in.rupam.accounts.dto.AllCustomerDetailsDto;
import in.rupam.accounts.services.impl.CustomerDetailsService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api", produces = MediaType.APPLICATION_JSON_VALUE)
@Tag(
        name = "CRUD Rest APIs for customer details in My Bank",
        description = "CRUD REST API in my bank to get customer details"
)
@AllArgsConstructor
public class CustomerDetailsController {

    CustomerDetailsService customerDetailsService;

    @GetMapping("/getCustomerData")
    public ResponseEntity<AllCustomerDetailsDto> getAllCustomerData(@RequestParam String mobileNumber){
        AllCustomerDetailsDto allCustomerDetailsDto = customerDetailsService.getAllCustomerDetails(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(allCustomerDetailsDto);
    }
}
