package com.tobeto.rentalcardemo.services.dto.address.responses;

import lombok.Data;

@Data
public class GetAllAddressResponse {

    private String locationName;

    private String countryName;

    private String cityName;

    private String districtName;

    private String streetName;

    private String postCode;
}
