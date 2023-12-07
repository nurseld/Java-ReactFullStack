package com.tobeto.rentalcardemo.services.dto.address.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Data
@NoArgsConstructor
public class AddAddressRequest {


    @NotBlank(message = "Location name cannot be null or blank")
    private String locationName;


    @NotBlank(message = "Country name cannot be null or blank")
    private String countryName;


    @NotBlank(message = "City name cannot be null or blank")
    private String cityName;


    @NotBlank(message = "District name cannot be null or blank")
    private String districtName;

    @NotBlank(message = "Street name cannot be null or blank")
    private String streetName;

    @NotNull
    @Length(max = 5)
    private String postCode;
}
