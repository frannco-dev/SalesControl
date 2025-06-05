package com.franncodev.salescontrol.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long product_id;
    private String name;
    private String trademark;
    private Double value;
    private int stock;

    public Product() {
    }

    public Product(Long product_id, String name, String trademark, Double value, int stock) {
        this.product_id = product_id;
        this.name = name;
        this.trademark = trademark;
        this.value = value;
        this.stock = stock;
    }
}
