package com.haku.springbootdemo.Customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.config.CustomRepositoryImplementationDetector;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    CustomerRepository customerRepository;

    @Autowired
    public CustomerController(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Customer> getAll(){
        return customerRepository.findAll();
    }

    @RequestMapping
    public String getHome(){
        return "hello world;";
    }


}
