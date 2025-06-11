package com.franncodev.salescontrol.model;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter @Setter
public class Customer extends Person{

    public Customer() {
    }

    public Customer(Long person_id, String first_name, String last_name, String idCard, String email) {
        super(person_id, first_name, last_name, idCard, email);
    }
}
