package com.franncodev.salescontrol.mapper;

import com.franncodev.salescontrol.dto.CustomerDTO;
import com.franncodev.salescontrol.model.Customer;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ICustomerMapper {

    ICustomerMapper INSTANCE = Mappers.getMapper(ICustomerMapper.class);

    CustomerDTO customerToCustomerDTO(Customer customer);

    List<CustomerDTO> listCustomerToListCustomerDTO(List<Customer> customers);

}
