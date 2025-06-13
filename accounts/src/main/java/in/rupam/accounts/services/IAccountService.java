package in.rupam.accounts.services;

import in.rupam.accounts.dto.CustomerDto;

public interface IAccountService {
    /**
     * @param customerDto - Cutomer DTo object
     */
    void createAccount(CustomerDto customerDto);

    /**
     * @param mobileNumber
     * @return CustomerDto with customer details
     */
    CustomerDto getCustomer(String mobileNumber);

    /**
     * updates customer details based on the accountNumberProvided
     *
     * @param customerDto customerDTO object
     * @returns a boolean value
     */
    boolean updateCustomer(CustomerDto customerDto);

    /**
     * delete customer and account related to customer
     *
     * @param mobileNumber customer's mobile number
     * @return boolean
     */
    boolean deleteCustomer(String mobileNumber);

    /**
     * updates the communication sw once recieved from message repo
     *
     * @param accountNumber
     * @return
     */
    boolean updateCommunicationStatus(Long accountNumber);
}
