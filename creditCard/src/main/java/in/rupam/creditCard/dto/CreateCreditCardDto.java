package in.rupam.creditCard.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateCreditCardDto {
    private String customerMobileNumber;

    private String cardType;

    private String network;
}
