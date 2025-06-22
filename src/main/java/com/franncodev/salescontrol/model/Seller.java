package com.franncodev.salescontrol.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Seller extends Person{

    private String sellerId;

    public Seller() {
    }

    public Seller(String sellerId) {
        this.sellerId = sellerId;
    }

    public Seller(Long personId, String firstName, String lastName, String idCard, String email, String sellerId) {
        super(personId, firstName, lastName, idCard, email);
        this.sellerId = sellerId;
    }
}
