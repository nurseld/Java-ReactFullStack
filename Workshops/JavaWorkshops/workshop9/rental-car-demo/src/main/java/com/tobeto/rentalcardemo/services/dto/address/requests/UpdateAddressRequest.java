package com.tobeto.rentalcardemo.services.dto.address.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
public class UpdateAddressRequest {

    @NotNull(message = "Address ID cannot be null")
    @Positive(message = "Address ID must be a positive number")
    private Integer addressId;

    @NotBlank(message = "Location name cannot be blank")
    private String locationName;

    @NotBlank(message = "Country name cannot be blank")
    private String countryName;

    @NotBlank(message = "City name cannot be blank")
    private String cityName;

    @NotBlank(message = "District name cannot be blank")
    private String districtName;

    @NotBlank(message = "Street name cannot be blank")
    private String streetName;

    @NotBlank(message = "Post code cannot be blank")
    @Length(max = 5)
    private String postCode;
}
