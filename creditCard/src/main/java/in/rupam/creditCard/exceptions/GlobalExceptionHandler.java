package in.rupam.creditCard.exceptions;

import in.rupam.creditCard.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ExceptionDto handlenotFoundException(NotFoundException e){
        return new ExceptionDto(HttpStatus.NOT_FOUND, e.getMessage());
    }

    @ExceptionHandler(CardValidationFailedException.class)
    public ExceptionDto handleCardValidationFailedException(CardValidationFailedException e){
        return new ExceptionDto(HttpStatus.BAD_REQUEST, e.getMessage());
    }
}
