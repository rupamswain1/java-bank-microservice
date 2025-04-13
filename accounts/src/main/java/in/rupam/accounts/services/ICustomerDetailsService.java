package in.rupam.accounts.services;

import in.rupam.accounts.dto.AllCustomerDetailsDto;

public interface ICustomerDetailsService {
    AllCustomerDetailsDto getAllCustomerDetails(String mobileNumber);
}
