package com.franncodev.salescontrol.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter @Setter
public class Sale {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long saleId;
    private LocalDate saleDate;
    private Double totalPrice;

    @ManyToMany
    private List<Product> productList;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Seller seller;

    public Sale() {
    }

    public Sale(Long saleId, List<Product> productList, Customer customer, Seller seller) {
        this.saleId = saleId;
        this.productList = productList;
        this.customer = customer;
        this.seller = seller;
    }
}
