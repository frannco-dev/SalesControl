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
    private Long sale_id;
    private LocalDate sale_date;
    private Double price;

    @ManyToMany
    private List<Product> productList;

    @ManyToOne
    private Customer customer;

    @ManyToOne
    private Seller seller;

    public Sale() {
    }

    public Sale(Long sale_id, LocalDate sale_date, Double price, List<Product> productList, Customer customer, Seller seller) {
        this.sale_id = sale_id;
        this.sale_date = sale_date;
        this.price = price;
        this.productList = productList;
        this.customer = customer;
        this.seller = seller;
    }
}
