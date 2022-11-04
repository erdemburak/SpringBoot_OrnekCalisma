package com.burakerdem.business.services;

import com.burakerdem.business.dto.CustomerDto;
import com.burakerdem.business.dto.entity.Customer;

import java.util.List;

public interface MainService {

    /////// Crud ///////////////////////////////////////

    public CustomerDto addCustomer(CustomerDto customerDto);
    public List<CustomerDto> getCustomers();
    public CustomerDto getCustomerById(Long customerId);
    public Boolean deleteCustomerById(Long customerId);

    ////// Model Mapper /////////////////////////////////

    public CustomerDto CustomerToDto(Customer customer);
    public Customer DtoToCustomer(CustomerDto customerDto);

}