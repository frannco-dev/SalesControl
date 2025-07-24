package com.franncodev.salescontrol.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class CustomerDTO {

    private String firstName;
    private String lastName;
    private String idCard;
    private String email;

}
