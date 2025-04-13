package in.rupam.accounts.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
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
public class CustomerDetailsController {
    @GetMapping("/getCustoerData")
    public ResponseEntity<String> getAllCustomerData(@RequestParam long mobileNumber){

    }
}
