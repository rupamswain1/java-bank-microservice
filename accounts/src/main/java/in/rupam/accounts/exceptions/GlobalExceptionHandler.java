package in.rupam.accounts.exceptions;

import in.rupam.accounts.dto.ErrorMessageDto;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.Nullable;
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
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> validationErrors = new HashMap<>();
        List<ObjectError> validationErrorList = ex.getBindingResult().getAllErrors();

        validationErrorList.forEach((error) -> {
            String filedName = ((FieldError) error).getField();
            String validationMessage = error.getDefaultMessage();
            validationErrors.put(filedName, validationMessage);
        });
        return new ResponseEntity<>(validationErrors, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessageDto> handleGlobalException(Exception exception, WebRequest webRequest) {
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(
                HttpStatus.INTERNAL_SERVER_ERROR,
                exception.getMessage(),
                LocalDateTime.now(),
                webRequest.getDescription((false))
        );
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(errorMessageDto);
    }

    @ExceptionHandler(CustomerAlreadyExistsException.class)
    public ResponseEntity<ErrorMessageDto> handleCustomerAlreadyExistsException(CustomerAlreadyExistsException customerAlreadyExistsException, WebRequest webRequest) {
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(
                HttpStatus.BAD_REQUEST,
                customerAlreadyExistsException.getMessage(),
                LocalDateTime.now(),
                webRequest.getDescription(false)
        );
        return new ResponseEntity<>(errorMessageDto, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ResourceNotAvailableException.class)
    public ResponseEntity<ErrorMessageDto> handleResourceNotFoundException(ResourceNotAvailableException exception, WebRequest webRequest) {
        ErrorMessageDto errorMessageDto = new ErrorMessageDto(
                HttpStatus.NOT_FOUND,
                exception.getMessage(),
                LocalDateTime.now(),
                webRequest.getDescription(false)
        );
        return new ResponseEntity<>(errorMessageDto, HttpStatus.NOT_FOUND);
    }

}
