package com.franncodev.salescontrol.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Customer extends Person{

    public Customer() {
    }

    public Customer(Long person_id, String name, String surname, String idCard, String email) {
        super(person_id, name, surname, idCard, email);
    }
}
