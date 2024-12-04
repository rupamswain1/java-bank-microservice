package com.rupa.loanApplication.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
public class ResponseDto {
    private HttpStatus httpStatus;
    private String message;
}
