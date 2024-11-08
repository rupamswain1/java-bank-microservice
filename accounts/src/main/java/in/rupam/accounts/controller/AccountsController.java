package in.rupam.accounts.controller;

import in.rupam.accounts.constants.AccountConstants;
import in.rupam.accounts.dto.CustomerDto;
import in.rupam.accounts.dto.ResponseDto;
import in.rupam.accounts.services.impl.AccountService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api", produces = (MediaType.APPLICATION_JSON_VALUE))
@AllArgsConstructor
public class AccountsController {

    AccountService accountService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        accountService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchCustomer(@RequestParam String mobileNumber) {
        return new ResponseEntity<>(accountService.getCustomer(mobileNumber), HttpStatus.OK);
    }
}
