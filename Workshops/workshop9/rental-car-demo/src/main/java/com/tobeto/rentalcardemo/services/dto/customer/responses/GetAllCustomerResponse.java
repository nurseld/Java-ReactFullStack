package com.tobeto.rentalcardemo.services.dto.customer.responses;

import lombok.Data;

@Data
public class GetAllCustomerResponse {

    private String firstName;

    private String middleName;

    private String surName;

    private Integer age;
}
