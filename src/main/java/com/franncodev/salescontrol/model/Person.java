package com.franncodev.salescontrol.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@MappedSuperclass
@Getter @Setter
public abstract class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long personId;
    private String firstName;
    private String lastName;
    private String idCard;
    private String email;

    public Person() {
    }

    public Person(Long personId, String firstName, String lastName, String idCard, String email) {
        this.personId = personId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.idCard = idCard;
        this.email = email;
    }
}
