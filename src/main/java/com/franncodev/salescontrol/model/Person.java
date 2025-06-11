package com.franncodev.salescontrol.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long person_id;
    private String first_name;
    private String last_name;
    private String idCard;
    private String email;

    public Person() {
    }

    public Person(Long person_id, String first_name, String last_name, String idCard, String email) {
        this.person_id = person_id;
        this.first_name = first_name;
        this.last_name = last_name;
        this.idCard = idCard;
        this.email = email;
    }
}
