package com.tobeto.rentalcardemo.services.dto.address.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllAddressResponse {

    private Integer id;

    private String cityName;

    private String locationName;

    private String countryName;

    private String districtName;

    private String streetName;

    private String postCode;
}
