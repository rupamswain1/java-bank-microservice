package com.rupam.loanApplication.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@Schema(
        name = "error message dto class",
        description = "format to send the error message"
)
public class ErrorMessageDto {
    @Schema(
            description = "error status code",
            example = "500"
    )
    private HttpStatus statusCode;
    @Schema(
            description = "error message description",
            example="resouorce not available"
    )
    private String message;
    @Schema(
            description = "time of error",
            example = "2024-01-01"
    )
    private LocalDateTime time;
    @Schema(
            description = "path of error",
            example = "api/loan"
    )
    private String path;
}
