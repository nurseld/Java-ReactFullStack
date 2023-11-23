package com.tobeto.rentalcardemo.services.dto.car.requests;

import lombok.Data;

@Data
public class AddCarRequest {

    private String brandName;

    private String modelName;

    private int modelYear;

    private String fuelType;

    private String gearType;

    private double dailyPrice;
}
