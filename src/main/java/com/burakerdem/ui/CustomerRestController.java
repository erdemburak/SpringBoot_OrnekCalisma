package com.burakerdem.ui;

import com.burakerdem.business.services.ExternalService;
import com.burakerdem.business.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/customer")
@CrossOrigin(origins = "http://localhost:8070")
public class CustomerRestController {

    @Autowired
    private ExternalService externalService;

    @PostMapping("/save")
    public CustomerDto addCustomer(@RequestBody CustomerDto customerDto){
        externalService.addCustomer(customerDto);
        return customerDto;
    }

    @GetMapping("/{customerId}")
    public CustomerDto getCustomerById(@PathVariable Long customerId){
        return externalService.getCustomerById(customerId);
    }

    @GetMapping("/list")
    public List<CustomerDto> getCustomers(){
        return externalService.getCustomers();
    }

    @DeleteMapping("/delete/{customerId}")
    public Boolean deleteCustomerById(@PathVariable(required = true) Long customerId){
        return externalService.deleteCustomerById(customerId);
    }

}
