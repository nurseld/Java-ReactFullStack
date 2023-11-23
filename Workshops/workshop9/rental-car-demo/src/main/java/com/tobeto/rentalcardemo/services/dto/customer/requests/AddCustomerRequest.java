package com.tobeto.rentalcardemo.services.dto.customer.requests;

import lombok.Data;

@Data
public class AddCustomerRequest {

    private String firstName;

    private String middleName;

    private String surName;

    private Integer age;

}
