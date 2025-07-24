package com.franncodev.salescontrol.dto;

import com.franncodev.salescontrol.model.Customer;
import com.franncodev.salescontrol.model.Product;
import com.franncodev.salescontrol.model.Seller;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class SaleDTO {

    private LocalDate saleDate;
    private Double totalPrice;
    private List<Product> productList;
    private Customer customer;
    private Seller seller;

}
