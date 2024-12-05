package com.rupam.loanApplication.controller;

import com.rupam.loanApplication.dto.LoanDto;
import com.rupam.loanApplication.dto.ResponseDto;
import com.rupam.loanApplication.service.impl.LoanService;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
@Tag(
        name="Loan Service for my bank",
        description = "This is loan service for my bank"
)
public class LoanController {
    LoanService loanService;
    @GetMapping("/getCustomerLoans")
    public ResponseEntity<List<LoanDto>> getCustomerLoans(@RequestParam String mobileNumber){
        List<LoanDto> loanDtos = loanService.getCustomerLoan(mobileNumber);
        return ResponseEntity.status(HttpStatus.OK).body(loanDtos);
    };

    @GetMapping("/getLoan")
    public String getLoan(@RequestParam Long loanId){
        return "Hekko";
    };

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLoan(@RequestBody LoanDto loanDto){
        loanService.CreateLoan(loanDto);
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
