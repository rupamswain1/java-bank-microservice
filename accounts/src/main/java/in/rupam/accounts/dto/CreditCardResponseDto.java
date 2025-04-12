package in.rupam.accounts.dto;

import java.time.LocalDateTime;

public class CreditCardResponseDto {
    private Long cardNumber;

    private String customerMobileNumber;

    private LocalDateTime validTill;

    private int cvv;

    private String cardType;

    private String network;

    private Long cardLimit;

    private Long prevMonthDue;

    private Long currentAvailableLimit;

    private Long currentMonthDue;

    private LocalDateTime dueDate;

    public CreditCardResponseDto(Long cardNumber, String customerMobileNumber, LocalDateTime validTill, int cvv, String cardType, String network, int pin, Long cardLimit, Long prevMonthDue, Long currentAvailableLimit, Long currentMonthDue, LocalDateTime dueDate) {
        this.cardNumber = cardNumber;
        this.customerMobileNumber = customerMobileNumber;
        this.validTill = validTill;
        this.cvv = cvv;
        this.cardType = cardType;
        this.network = network;
        this.cardLimit = cardLimit;
        this.prevMonthDue = prevMonthDue;
        this.currentAvailableLimit = currentAvailableLimit;
        this.currentMonthDue = currentMonthDue;
        this.dueDate = dueDate;
    }

    public CreditCardResponseDto() {
    }

    public Long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(Long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public LocalDateTime getValidTill() {
        return validTill;
    }

    public void setValidTill(LocalDateTime validTill) {
        this.validTill = validTill;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getNetwork() {
        return network;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public Long getCardLimit() {
        return cardLimit;
    }

    public void setCardLimit(Long cardLimit) {
        this.cardLimit = cardLimit;
    }

    public Long getPrevMonthDue() {
        return prevMonthDue;
    }

    public void setPrevMonthDue(Long prevMonthDue) {
        this.prevMonthDue = prevMonthDue;
    }

    public Long getCurrentAvailableLimit() {
        return currentAvailableLimit;
    }

    public void setCurrentAvailableLimit(Long currentAvailableLimit) {
        this.currentAvailableLimit = currentAvailableLimit;
    }

    public Long getCurrentMonthDue() {
        return currentMonthDue;
    }

    public void setCurrentMonthDue(Long currentMonthDue) {
        this.currentMonthDue = currentMonthDue;
    }

    public LocalDateTime getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDateTime dueDate) {
        this.dueDate = dueDate;
    }
}
