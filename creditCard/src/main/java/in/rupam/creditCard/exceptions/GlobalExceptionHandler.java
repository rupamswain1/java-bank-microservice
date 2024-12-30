package in.rupam.creditCard.exceptions;

import in.rupam.creditCard.dto.ExceptionDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ExceptionDto handlenotFoundException(Exception e){
        return new ExceptionDto(HttpStatus.NOT_FOUND, e.getMessage());
    }
}
