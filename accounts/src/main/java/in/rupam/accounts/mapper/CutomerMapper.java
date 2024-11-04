package in.rupam.accounts.mapper;

import in.rupam.accounts.dto.CustomerDto;
import in.rupam.accounts.model.Customer;

public class CutomerMapper {

    public static CustomerDto mapCustomerToDto(Customer customer, CustomerDto customerDto) {
        customerDto.setEmail(customer.getEmail());
        customerDto.setMobileNumber(customer.getMobileNumber());
        customerDto.setName(customer.getName());
        return customerDto;
    }

    public static Customer mapDtoToCustomer(CustomerDto customerDto, Customer customer) {
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }
}
