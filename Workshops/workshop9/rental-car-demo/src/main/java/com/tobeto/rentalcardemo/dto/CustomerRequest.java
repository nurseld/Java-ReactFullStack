package com.tobeto.rentalcardemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CustomerRequest {

    private int customerId;

    private String firstName;

    private String middleName;

    private String surName;

    private int age;

    private String citizenShipId;

}
