package in.rupam.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorMessageDto {
    private String statusCode;
    private String message;
    private LocalDateTime time;
    private String path;
}
