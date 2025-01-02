package in.rupam.creditCard.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;
import java.util.Map;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class CardValidationFailedException extends RuntimeException{
    private List<String> errorFields;

    public CardValidationFailedException(List<String> errors){
        super(String.join(",",errors)+ " are incorrect");
        String errorMessage = String.join(",",errors)+ " are incorrect";
        this.errorFields = errors;
    }

    public List<String> getErrorFields() {
        return errorFields;
    }

    public void setErrorFields(List<String> errorFields) {
        this.errorFields = errorFields;
    }
}
