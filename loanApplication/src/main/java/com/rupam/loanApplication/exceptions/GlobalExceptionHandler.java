package com.rupam.loanApplication.exceptions;

import com.rupam.loanApplication.dto.ErrorMessageDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @Override
    public ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException e, HttpHeaders httpHeaders, HttpStatusCode httpStatusCode, WebRequest webRequest){
        Map<String, String> errors = new HashMap<>();
        List<ObjectError> errorList = e.getBindingResult().getAllErrors();
        errorList.forEach((error)->{
            String fieldName = ((FieldError) error).getField();
            String validationMessage = error.getDefaultMessage();
            errors.put(fieldName, validationMessage);
        });
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

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

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessageDto> handleAllExcepiton(Exception exception, WebRequest webRequest){
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(
                HttpStatus.BAD_REQUEST,
                exception.getMessage(),
                LocalDateTime.now(),
                webRequest.getDescription(false)
        );
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(errorMessageDto);
    }
}
