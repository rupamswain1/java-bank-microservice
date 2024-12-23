package in.rupam.creditCard.dto;


public class CreateCreditCardDto {
    private String customerMobileNumber;

    private String cardType;

    private String network;

    public String getCustomerMobileNumber() {
        return customerMobileNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public String getNetwork() {
        return network;
    }

    public void setCustomerMobileNumber(String customerMobileNumber) {
        this.customerMobileNumber = customerMobileNumber;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public void setNetwork(String network) {
        this.network = network;
    }

    public CreateCreditCardDto(String customerMobileNumber, String cardType, String network) {
        this.customerMobileNumber = customerMobileNumber;
        this.cardType = cardType;
        this.network = network;
    }
}
