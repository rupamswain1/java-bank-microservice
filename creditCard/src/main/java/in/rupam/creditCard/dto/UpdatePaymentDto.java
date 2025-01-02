package in.rupam.creditCard.dto;

public class UpdatePaymentDto {
    private long cardNumber;
    private int cvv;
    private String expiry;
    private long amount;
    private int pin;

    public UpdatePaymentDto(long cardNumber, int cvv, String expiry, long amount, int pin) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiry = expiry;
        this.amount = amount;
        this.pin = pin;
    }
    public UpdatePaymentDto() {
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

    public long getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(long cardNumber) {
        this.cardNumber = cardNumber;
    }

    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

    public String getExpiry() {
        return expiry;
    }

    public void setExpiry(String expiry) {
        this.expiry = expiry;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
