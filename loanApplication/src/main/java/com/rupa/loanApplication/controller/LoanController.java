package com.rupa.loanApplication.controller;

import com.rupa.loanApplication.dto.LoanDto;
import com.rupa.loanApplication.dto.ResponseDto;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
@Tag(
        name="Loan Service for my bank",
        description = "This is loan service for my bank"
)
public class LoanController {
    @GetMapping("/getCustomerLoans")
    public String getCustomerLoans(@RequestParam String mobileNumber){
        return "Hekko";
    };

    @GetMapping("/getLoan")
    public String getLoan(@RequestParam Long loanId){
        return "Hekko";
    };

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(@RequestBody LoanDto loanDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseDto(HttpStatus.CREATED, "Loan Created")
        );
    }

    @DeleteMapping("/deleteLoan")
    public ResponseEntity<ResponseDto> deleteLoan(@RequestParam Long loanId){
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new ResponseDto(HttpStatus.CREATED, "Loan Created")
        );
    }

}
