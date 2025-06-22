package com.franncodev.salescontrol.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Customer extends Person{

    public Customer() {
    }

    public Customer(Long personId, String firstName, String lastName, String idCard, String email) {
        super(personId, firstName, lastName, idCard, email);
    }
}
