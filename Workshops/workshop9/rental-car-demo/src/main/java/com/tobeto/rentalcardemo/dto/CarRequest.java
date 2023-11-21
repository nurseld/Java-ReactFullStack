package com.tobeto.rentalcardemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CarRequest {

    private Integer id;

    private String brandName;

    private String modelName;

    private int modelYear;

    private String fuelType;

    private String gearType;

    private double dailyPrice;

}
