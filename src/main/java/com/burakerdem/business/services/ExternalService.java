package com.burakerdem.business.services;

import com.burakerdem.business.dao.CustomerDao;
import com.burakerdem.business.dto.CustomerDto;
import lombok.Getter;
import lombok.Setter;
import org.modelmapper.ModelMapper;
import com.burakerdem.data.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExternalService implements MainService{

    @Autowired @Getter @Setter
    private CustomerDao customerDao;
    @Autowired
    private ModelMapper modelMapper;

    @PostMapping("/customers")
    @Override
    public CustomerDto addCustomer(@RequestBody CustomerDto customerDto) {
        Customer customer1 = DtoToCustomer(customerDto);
        customerDao.save(customer1);
        return customerDto;
    }

    @GetMapping("/customers")
    @Override
    public List<CustomerDto> getCustomers() {
        List<CustomerDto> listDto = new ArrayList<>();
        List<Customer> customers = customerDao.findAll();
        for(Customer customer : customers){
            CustomerDto customerDto = CustomerToDto(customer);
            listDto.add(customerDto);
        }
        return listDto;
    }

    @GetMapping("/customers/{id}")
    @Override
    public CustomerDto getCustomerById(@PathVariable(name = "id") Long customerId) {
        Customer customer = customerDao.getCustomerById(customerId);
        CustomerDto customerDto = CustomerToDto(customer);
        return customerDto;
    }

    @DeleteMapping("/customers/{id}")
    @Override
    public Boolean deleteCustomerById(@PathVariable(name = "id") Long customerId) {
        customerDao.deleteById(customerId);
        return true;
    }

    ////// Model Mapper /////////////////////////////////

    //Customer --> Dto
    @Override
    public CustomerDto CustomerToDto(Customer customer) {
        CustomerDto customerDto = modelMapper.map(customer, CustomerDto.class);
        return customerDto;
    }
    //Dto --> Customer
    @Override
    public Customer DtoToCustomer(CustomerDto customerDto) {
        Customer customer = modelMapper.map(customerDto, Customer.class);
        return customer;
    }
}
