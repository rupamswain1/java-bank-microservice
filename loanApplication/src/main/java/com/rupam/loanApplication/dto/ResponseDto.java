package com.rupam.loanApplication.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@Schema(
        name="Model to accept loan update request",
        description = "dto class to update loan data"
)
public class ResponseDto {
    @Schema(
            description = "Response code",
            example="200"
    )
    private HttpStatus httpStatus;
    @Schema(
            description = "Response Message",
            example="Success"
    )
    private String message;
}
