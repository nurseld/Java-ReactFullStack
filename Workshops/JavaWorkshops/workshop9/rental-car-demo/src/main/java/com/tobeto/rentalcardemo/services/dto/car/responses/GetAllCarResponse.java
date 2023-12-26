package com.tobeto.rentalcardemo.services.dto.car.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllCarResponse {

    private String brandName;

    private String modelName;

    private int modelYear;

    private String fuelType;

    private String gearType;

    private double dailyPrice;
}
