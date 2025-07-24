package com.franncodev.salescontrol.service;

import com.franncodev.salescontrol.dto.CustomerDTO;
import com.franncodev.salescontrol.model.Customer;
import com.franncodev.salescontrol.model.Seller;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    public CustomerDTO createCustomer(Customer customer);

    public List<CustomerDTO> getCustomerList();

    public Optional<CustomerDTO> getCustomer(Long id);

    public void deleteCustomer(Long id);

    public CustomerDTO updateCustomer(Customer customer);

}
