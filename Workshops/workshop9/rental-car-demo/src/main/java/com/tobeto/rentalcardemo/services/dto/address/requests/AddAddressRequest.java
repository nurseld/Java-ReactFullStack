package com.tobeto.rentalcardemo.services.dto.address.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddAddressRequest {

    private String locationName;

    private String countryName;

    private String cityName;

    private String districtName;

    private String streetName;

    private String postCode;
}
