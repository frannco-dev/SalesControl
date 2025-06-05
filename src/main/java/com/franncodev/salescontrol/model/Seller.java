package com.franncodev.salescontrol.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Seller extends Person{

    private String seller_id;

    public Seller() {
    }

    public Seller(String seller_id) {
        this.seller_id = seller_id;
    }

    public Seller(Long person_id, String name, String surname, String idCard, String email, String seller_id) {
        super(person_id, name, surname, idCard, email);
        this.seller_id = seller_id;
    }

}
