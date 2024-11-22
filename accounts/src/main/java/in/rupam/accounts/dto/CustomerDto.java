package in.rupam.accounts.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Schema(
        name = "Customer DTO",
        description = "Details required to create or update customer"
)
public class CustomerDto {
    @NotEmpty(message = "Name can not be empty")
    @Size(min = 5, max = 15, message = "Lenght of name should be between 5 and 15")
    @Schema(
            description = "Name of customer",
            example = "Tony Stark"
    )
    private String name;

    @Schema(
            description = "Email of customer",
            example = "iamironman@startindusty.com"
    )
    @NotEmpty(message = "email can not be empty")
    @Email(message = "Email should be valid")
    private String email;

    @Schema(
            description = "customer's mobile number",
            example = "7894561230"
    )
    @Pattern(regexp = "(^$|[0-9]{10})", message = "Mobile Number must be 10 digits")
    private String mobileNumber;
    @Valid
    private AccountDto accountDto;
}
