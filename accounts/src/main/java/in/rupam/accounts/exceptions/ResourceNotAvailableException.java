package in.rupam.accounts.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotAvailableException extends RuntimeException {
    public ResourceNotAvailableException(String resourceName, String fieldName, String mobileNumber) {
        super(String.format("%s not found with the given input data %s : %s", resourceName, fieldName, mobileNumber));
    }

    public ResourceNotAvailableException(String resourceName, String fieldName, Long accountNumber) {
        super(String.format("%s not found with the given input data %s : %s", resourceName, fieldName, accountNumber));
    }
}

