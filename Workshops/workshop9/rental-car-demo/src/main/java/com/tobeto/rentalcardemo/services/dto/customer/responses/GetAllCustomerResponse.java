package com.tobeto.rentalcardemo.services.dto.customer.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCustomerResponse {

    private String firstName;

    private String middleName;

    private String surName;

    private Integer age;
}
