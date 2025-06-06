package com.franncodev.salescontrol.service;

import com.franncodev.salescontrol.model.Customer;

import java.util.List;

public interface ICustomerService {

    public void createCustomer(Customer customer);

    public List<Customer> getCustomerList();

    public Customer getCustomer(Long id);

    public void deleteCustomer(Long id);

    public void updateCustomer(Customer customer);

}
