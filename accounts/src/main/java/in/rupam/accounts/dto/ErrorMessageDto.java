package in.rupam.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorMessageDto {
    private HttpStatus statusCode;
    private String message;
    private LocalDateTime time;
    private String path;
}
