package com.rupam.loanApplication.controller;

import com.rupam.loanApplication.constants.Messages;
import com.rupam.loanApplication.dto.ErrorMessageDto;
import com.rupam.loanApplication.dto.LoanDto;
import com.rupam.loanApplication.dto.LoanUpdateDto;
import com.rupam.loanApplication.dto.ResponseDto;
import com.rupam.loanApplication.service.impl.LoanService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api")
@Tag(
        name="Loan Service for my bank",
        description = "This is loan service for my bank"
)
@Validated
public class LoanController {

    @Value("${build.version}")
    private String buildVersion;

    @Value(("${loans.message}"))
    private String message;

    @Autowired
    LoanService loanService;

    @GetMapping("/getCustomerLoans")
    @Operation(
            summary = "Get customer loan",
            description = "Get customer loan using customerMobileNumber"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Loan Details of customer is found"

            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Customer Loan details not found",
                    content = @Content(
                            schema = @Schema(implementation = ErrorMessageDto.class)
                    )

            )
    })
    public ResponseEntity<List<LoanDto>> getCustomerLoans(@RequestParam
                                                                @NotEmpty(message = Messages.CUSTOMER_MOBILE_REQUIRED)
                                                              @Pattern(regexp = "(^$|[0-9]{10})", message = Messages.TEN_DIGIT_LENGTH)
                                                              String mobileNumber){
        List<LoanDto> loanDtos = loanService.getCustomerLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(loanDtos);
    };

    @GetMapping("/getLoan")
    @Operation(
            summary = "get Loan",
            description = "get Customer loan by loanId"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Loan Found"
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Loan with loanId is not available",
                    content = @Content(schema=@Schema(implementation = ErrorMessageDto.class))

            )
    })
    public ResponseEntity<LoanDto> getLoan(@RequestParam
                                                @NotNull(message = "loanId is required")
                                               @Min(value = 1000000000L, message = "loanId should be of min 10 digits")
                                               @Max(value = 9999999999L, message = "loanId should be of max 10 digits")
                                               Long loanId){
        return ResponseEntity.status(HttpStatus.OK).body(loanService.getLoan(loanId));
    };

    @PostMapping("/create")
    @Operation(
            summary = "Create a loan",
            description = "Creates a loan for customer, caclulates emi based on pricipal and duration"
    )
    @ApiResponses(
            {@ApiResponse(
                    responseCode = "201",
                    description = "Loan created",
                    content = @Content(schema = @Schema(implementation = ResponseDto.class))
            ),
                    @ApiResponse(
                            responseCode = "500",
                            description = "Loan Failed",
                            content = @Content(schema = @Schema(implementation = ErrorMessageDto.class))
                    )}
    )
    public ResponseEntity<ResponseDto> createLoan(@Valid @RequestBody LoanDto loanDto){
        loanService.CreateLoan(loanDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseDto(HttpStatus.CREATED, "Loan Created")
        );
    }

    @PutMapping("/updateLoan")
    @Operation(
            summary = "Updates Loan",
            description = "Updates loan based on the loanId and other details"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "201",
                    description = "Loan Updated",
                    content = @Content(schema = @Schema(implementation = ResponseDto.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Loan Not found",
                    content = @Content(schema = @Schema(implementation = ErrorMessageDto.class))
            )
    })
    public ResponseEntity<ResponseDto> updateLoan(@Valid @RequestBody LoanUpdateDto loanUpdateDto){
        loanService.updateLoan(loanUpdateDto);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDto(HttpStatus.CREATED, "Loan Updated")
        );
    }

    @DeleteMapping("/deleteLoan")
    @Operation(
            summary = "Delete loan by loanId",
            description = "Deletes customer loan by loan id, one at a time"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Loan Deleted",
                    content = @Content(schema = @Schema(implementation = ResponseDto.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Loan Not found",
                    content = @Content(schema = @Schema(implementation = ErrorMessageDto.class))
            )
    })
    public ResponseEntity<ResponseDto> deleteLoan(@RequestParam
                                                        @NotNull(message = "loanId is required")
                                                      @Min(value = 1000000000L, message = "loanId should be of min 10 digits")
                                                      @Max(value = 9999999999L, message = "loanId should be of max 10 digits")
                                                      Long loanId){
        loanService.deleteLoan(loanId);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseDto(HttpStatus.CREATED, "Loan Deleted")
        );
    }
    @DeleteMapping("/deleteCustomer")
    @Operation(
            summary = "Delete all loans by customerMobileNumber",
            description = "Deletes all customer loan by customerMobileNumber"
    )
    @ApiResponses({
            @ApiResponse(
                    responseCode = "200",
                    description = "Loan Deleted",
                    content = @Content(schema = @Schema(implementation = ResponseDto.class))
            ),
            @ApiResponse(
                    responseCode = "500",
                    description = "Loan Not found",
                    content = @Content(schema = @Schema(implementation = ErrorMessageDto.class))
            )
    })
    public ResponseEntity<ResponseDto> deleteCustomer(@RequestParam
    @NotEmpty
                                                          @Pattern(regexp = "(^$|[0-9]{10})", message = Messages.TEN_DIGIT_LENGTH)
                                                          String mobileNumber){
        loanService.closeCustomerAccount(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(
                new ResponseDto(HttpStatus.CREATED, "Success")
        );
    }

    @GetMapping("/build-info")
    public Map<String, Object> getBuildInfo(){
        return Map.of(
                "version", buildVersion,
                "message", message
        );
    }

}
