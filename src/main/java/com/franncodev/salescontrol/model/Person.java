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
    private String name;
    private String surname;
    private String idCard;
    private String email;

    public Person() {
    }

    public Person(Long person_id, String name, String surname, String idCard, String email) {
        this.person_id = person_id;
        this.name = name;
        this.surname = surname;
        this.idCard = idCard;
        this.email = email;
    }
}
