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
}
