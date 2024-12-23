package in.rupam.creditCard.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

@Entity
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

    public CreditCard() {
        super();
    }

    public CreditCard(Long cardNumber, String customerMobileNumber, LocalDateTime validTill, int cvv, String cardType, String network, int pin, Long cardLimit, Long prevMonthDue, Long currentAvailableLimit, Long currentMonthDue, LocalDateTime dueDate) {
        this.cardNumber = cardNumber;
        this.customerMobileNumber = customerMobileNumber;
        this.validTill = validTill;
        this.cvv = cvv;
        this.cardType = cardType;
        this.network = network;
        this.pin = pin;
        this.cardLimit = cardLimit;
        this.prevMonthDue = prevMonthDue;
        this.currentAvailableLimit = currentAvailableLimit;
        this.currentMonthDue = currentMonthDue;
        this.dueDate = dueDate;
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public LocalDateTime getValidTill() {
        return validTill;
    }

    public int getCvv() {
        return cvv;
    }

    public String getCardType() {
        return cardType;
    }

    public String getNetwork() {
        return network;
    }

    public int getPin() {
        return pin;
    }

    public Long getCardLimit() {
        return cardLimit;
    }

    public Long getPrevMonthDue() {
        return prevMonthDue;
    }

    public Long getCurrentAvailableLimit() {
        return currentAvailableLimit;
    }

    public Long getCurrentMonthDue() {
        return currentMonthDue;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public void setValidTill(LocalDateTime validTill) {
        this.validTill = validTill;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public void setCardLimit(Long cardLimit) {
        this.cardLimit = cardLimit;
    }

    public void setPrevMonthDue(Long prevMonthDue) {
        this.prevMonthDue = prevMonthDue;
    }

    public void setCurrentAvailableLimit(Long currentAvailableLimit) {
        this.currentAvailableLimit = currentAvailableLimit;
    }

    public void setCurrentMonthDue(Long currentMonthDue) {
        this.currentMonthDue = currentMonthDue;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
