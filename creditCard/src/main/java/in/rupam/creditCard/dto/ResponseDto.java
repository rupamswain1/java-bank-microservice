package in.rupam.creditCard.dto;

import lombok.*;
import org.springframework.http.HttpStatusCode;

@Data
@NoArgsConstructor
public class ResponseDto {
    private String message;
    private HttpStatusCode statusCode;

    public ResponseDto(String message, HttpStatusCode statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
