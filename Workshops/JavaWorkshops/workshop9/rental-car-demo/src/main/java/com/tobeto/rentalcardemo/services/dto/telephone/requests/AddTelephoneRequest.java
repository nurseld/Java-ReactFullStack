package com.tobeto.rentalcardemo.services.dto.telephone.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddTelephoneRequest {

    @NotBlank(message = "Description cannot be blank")
    @Size(min = 2, max = 20, message = "Description must be between 2 and 20 characters")
    private String description;

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "Invalid phone number format")
    private String phoneNumber;


}
