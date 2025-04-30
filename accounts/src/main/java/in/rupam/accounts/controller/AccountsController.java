package in.rupam.accounts.controller;

import in.rupam.accounts.constants.AccountConstants;
import in.rupam.accounts.dto.AccountConfigDto;
import in.rupam.accounts.dto.CustomerDto;
import in.rupam.accounts.dto.ErrorMessageDto;
import in.rupam.accounts.dto.ResponseDto;
import in.rupam.accounts.services.impl.AccountService;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.lang.String;

@RestController
@RequestMapping(path = "/api", produces = (MediaType.APPLICATION_JSON_VALUE))
@Validated
@Tag(
        name = "CRUD Rest APIs for Account in My Bank",
        description = "CRUD REST API in my bank to create, update and delete the table"
)
public class AccountsController {

    @Value("${build.version}")
    private String buildVersion;

    @Autowired
    AccountService accountService;

    @Autowired
    AccountConfigDto accountConfigDto;

    @Operation(
            summary = "Create new Customer and Account",
            description = "REST API to create a new customer and account"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP status CREATED"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Failed",
                    content = @Content(
                            schema = @Schema(implementation = ErrorMessageDto.class)
                    )
            )
    })

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@Valid @RequestBody CustomerDto customerDto) {
        accountService.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountConstants.STATUS_201, AccountConstants.MESSAGE_201));
    }

    @Operation(
            summary = "Fetch custmer and Account details",
            description = "REST API to fetch customer and account details using mobile number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status OK"
            ),
            @ApiResponse(
                    responseCode = "404",
                    description = "error dto class",
                    content = @Content(
                            schema = @Schema(implementation = ErrorMessageDto.class)
                    )
            )
    })
    @RateLimiter(name = "fetchCustomer", fallbackMethod = "fetchCustomerLimiter")
    @GetMapping("/fetch")
    public ResponseEntity<CustomerDto> fetchCustomer(@RequestParam
                                                     @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits")
                                                     String mobileNumber) {
        return new ResponseEntity<>(accountService.getCustomer(mobileNumber), HttpStatus.OK);
    }

    public ResponseEntity<String> fetchCustomerLimiter(Throwable throwable) {
        return ResponseEntity.status(HttpStatus.OK).body("Ratelimiter Hit in accounts");
    }


    @Operation(
            summary = "Update customer and account details",
            description = "Updates Customer and Account details based on the account number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status updated"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorMessageDto.class)
                    )
            )
    })

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateCustomerAndAccount(@Valid @RequestBody CustomerDto customerDto) {
        boolean isUpdated = accountService.updateCustomer(customerDto);
        if (isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDto(AccountConstants.STATUS_500, AccountConstants.MESSAGE_500));
        }
    }

    @Operation(
            summary = "Deletes the account and customer",
            description = "Delete Customer and Account based on the account number"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "HTTP Status deleted"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorMessageDto.class)
                    )
            )
    })

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteCustomer(@RequestParam
                                                      @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits")
                                                      String mobileNumber) {
        boolean isDeleted = accountService.deleteCustomer(mobileNumber);
        if (isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(AccountConstants.STATUS_200, AccountConstants.MESSAGE_200));
        } else {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new ResponseDto(AccountConstants.STATUS_500, AccountConstants.MESSAGE_500));
        }
    }

    @GetMapping("/build-info")
    public Map<String, Object> getBuildInfo() {
        return Map.of(
                "version", buildVersion,
                "accounts", accountConfigDto
        );
    }
}
