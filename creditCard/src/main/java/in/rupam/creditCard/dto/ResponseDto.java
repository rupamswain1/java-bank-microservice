package in.rupam.creditCard.dto;

import lombok.*;
import org.springframework.http.HttpStatusCode;

@Data
public class ResponseDto {
    private String message;
    private HttpStatusCode statusCode;

    public ResponseDto(String message, HttpStatusCode statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatusCode getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(HttpStatusCode statusCode) {
        this.statusCode = statusCode;
    }
}
