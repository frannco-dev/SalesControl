package com.franncodev.salescontrol.service;

import com.franncodev.salescontrol.dto.CustomerDTO;
import com.franncodev.salescontrol.mapper.ICustomerMapper;
import com.franncodev.salescontrol.model.Customer;
import com.franncodev.salescontrol.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements ICustomerService{

    @Autowired
    ICustomerRepository customerRepository;

    @Override
    public CustomerDTO createCustomer(Customer customer) {
        return ICustomerMapper.INSTANCE.customerToCustomerDTO(customerRepository.save(customer));
    }

    @Override
    public List<CustomerDTO> getCustomerList() {
        return ICustomerMapper.INSTANCE.listCustomerToListCustomerDTO(customerRepository.findAll());
    }

    @Override
    public Optional<CustomerDTO> getCustomer(Long id) {
        return customerRepository.findById(id).map(ICustomerMapper.INSTANCE :: customerToCustomerDTO);
    }

    @Override
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public CustomerDTO updateCustomer(Customer customer) {
        return ICustomerMapper.INSTANCE.customerToCustomerDTO(customerRepository.save(customer));
    }
}
