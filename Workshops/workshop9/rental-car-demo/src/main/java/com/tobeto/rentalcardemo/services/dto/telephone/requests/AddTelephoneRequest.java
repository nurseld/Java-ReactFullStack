package com.tobeto.rentalcardemo.services.dto.telephone.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class AddTelephoneRequest {

    private String description;

    @NotBlank(message = "Phone number cannot be blank")
    @Pattern(regexp = "^\\+(?:[0-9] ?){6,14}[0-9]$", message = "Invalid phone number format")
    private String phoneNumber;
}
