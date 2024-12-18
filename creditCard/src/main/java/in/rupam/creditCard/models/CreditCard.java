package in.rupam.creditCard.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class CreditCard extends BaseModel{

    @Id
    private Long cardNumber;

    private String customerMobileNumber;

    private LocalDateTime validTill;

    private int cvv;

    private String cardType;

    private String network;

    private int pin;

    private Long cardLimit;

    private Long prevMonthDue;

    private Long currentAvailableLimit;

    private Long currentMonthDue;

    private LocalDateTime dueDate;

}
