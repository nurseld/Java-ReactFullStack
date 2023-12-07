package com.tobeto.rentalcardemo.services.dto.customer.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddCustomerRequest {

    @NotBlank(message = "First name cannot be blank")
    private String firstName;

    @Size(min = 0, message = "Middle name must have at least 0 characters")
    private String middleName;

    @NotBlank(message = "Surname cannot be blank")
    private String surName;

    @NotNull(message = "Age cannot be null")
    @Positive(message = "Age must be a positive number")
    private Integer age;

}
