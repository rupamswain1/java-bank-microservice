package com.rupa.loanApplication.exceptions;

import com.rupa.loanApplication.dto.ErrorMessageDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ResourceNotAvailableException.class)
    public ResponseEntity<ErrorMessageDto> handleResourceNotAvailableException(ResourceNotAvailableException exception, WebRequest webrequest){
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                LocalDateTime.now(),
                webrequest.getDescription(false)
        );
        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(errorMessageDto);
    }
}
