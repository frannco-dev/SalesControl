package com.franncodev.salescontrol.controller;

import com.franncodev.salescontrol.model.Customer;
import com.franncodev.salescontrol.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @PostMapping("/customers/create")
    public String createCustomer(@RequestBody Customer customer){
        customerService.createCustomer(customer);

        return "Customer created successfully";
    }

    @GetMapping("/customers")
    @ResponseBody
    public List<Customer> getCustomerList(){
        return customerService.getCustomerList();
    }

    @GetMapping("/customers/{customerId}")
    @ResponseBody
    public Customer getCustomer(@PathVariable Long customerId){
        return customerService.getCustomer(customerId);
    }

    @DeleteMapping("/customers/delete/{customerId}")
    public String deleteCustomer(@PathVariable Long customerId){
        customerService.deleteCustomer(customerId);

        return "Customer deleted successfully";
    }

    @PutMapping("/customers/update")
    public String updateCustomer(@RequestBody Customer customer){
        customerService.updateCustomer(customer);

        return "Customer updated successfully";
    }

}
