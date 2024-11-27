package com.rupa.loanApplication.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api")
@AllArgsConstructor
@Tag(
        name="Loan Service for my bank",
        description = "This is loan service for my bank"
)
public class LoanController {
    @GetMapping("/test")
    public String testApi(){
        return "Hekko";
    }
}
