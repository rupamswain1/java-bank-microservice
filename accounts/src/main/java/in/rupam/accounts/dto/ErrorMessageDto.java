package in.rupam.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@Schema(
        name = "Error message schema",
        description = "Format used to convey the error"
)
public class ErrorMessageDto {
    @Schema(
            description = "Status code for ERROR",
            example = "500"
    )
    private HttpStatus statusCode;
    @Schema(
            description = "ERROR Message",
            example = "Customer not found"
    )
    private String message;
    @Schema(
            description = "Date and time of error",
            example = "2007-12-03T10:15:3"
    )
    private LocalDateTime time;
    @Schema(
            description = "path for error",
            example = "api/fetch"
    )
    private String path;
}
