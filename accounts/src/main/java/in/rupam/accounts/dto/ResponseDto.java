package in.rupam.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@Schema(
        name = "Response Schema",
        description = "response format"
)
public class ResponseDto {
    @Schema(
            description = "Status code",
            example = "201"
    )
    private String statusCode;
    @Schema(
            description = "Respnse message",
            example = "Success"
    )
    private String message;
}
