package com.tobeto.rentalcardemo.services.dto.car.requests;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class AddCarRequest {

    @NotBlank(message = "Brand name cannot be blank")
    @Size(min = 2, message = "Brand name must have at least 2 characters")
    private String brandName;

    @NotBlank(message = "Model name cannot be blank")
    private String modelName;

    @Positive(message = "Model year must be a positive number")
    @Min(value = 2000, message = "Model year must be at least 2000")
    private int modelYear;

    @NotBlank(message = "Fuel type cannot be blank")
    private String fuelType;

    @NotBlank(message = "Gear type cannot be blank")
    private String gearType;

    @Positive(message = "Daily price must be a positive number")
    private double dailyPrice;
}
