package com.franncodev.salescontrol.controller;

import com.franncodev.salescontrol.dto.CustomerDTO;
import com.franncodev.salescontrol.model.Customer;
import com.franncodev.salescontrol.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Autowired
    ICustomerService customerService;

    @PostMapping("/create")
    public ResponseEntity<CustomerDTO> createCustomer(@RequestBody Customer customer){
        CustomerDTO createdCustomer = customerService.createCustomer(customer);

        return ResponseEntity.status(HttpStatus.CREATED).body(createdCustomer);
    }

    @GetMapping("")
    @ResponseBody
    public ResponseEntity<List<CustomerDTO>> getCustomerList(){
        return ResponseEntity.ok(customerService.getCustomerList());
    }

    @GetMapping("/{customerId}")
    @ResponseBody
    public ResponseEntity<Optional<CustomerDTO>> getCustomer(@PathVariable Long customerId){
        return ResponseEntity.ok(customerService.getCustomer(customerId));
    }

    @DeleteMapping("/delete/{customerId}")
    public ResponseEntity<Void> deleteCustomer(@PathVariable Long customerId){
        customerService.deleteCustomer(customerId);

        return ResponseEntity.noContent().build();
    }

    @PutMapping("/update")
    public ResponseEntity<CustomerDTO> updateCustomer(@RequestBody Customer customer){
        return ResponseEntity.ok(customerService.updateCustomer(customer));
    }

}
