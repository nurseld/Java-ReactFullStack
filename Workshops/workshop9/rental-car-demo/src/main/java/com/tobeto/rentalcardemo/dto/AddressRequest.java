package com.tobeto.rentalcardemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class AddressRequest {

    private Integer addressId;

    private String locationName;

    private String countryName;

    private String cityName;

    private String districtName;

    private String streetName;

    private String postCode;

}
