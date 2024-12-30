package in.rupam.creditCard.dto;

import org.springframework.http.HttpStatusCode;

public class ExceptionDto {
    private HttpStatusCode statusCode;
    private String message;

    public ExceptionDto(HttpStatusCode statusCode, String message) {
        this.statusCode = statusCode;
        this.message = message;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatusCode statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
