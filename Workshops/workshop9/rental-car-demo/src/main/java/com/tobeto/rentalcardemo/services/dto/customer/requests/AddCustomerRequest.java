package com.tobeto.rentalcardemo.services.dto.customer.requests;

import jakarta.validation.constraints.*;
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

    @NotBlank(message = "Citizenship ID cannot be blank")
    @Pattern(regexp = "[0-9]{11}", message = "Citizenship ID must be 11 digits")
    private String citizenShipId;


}
