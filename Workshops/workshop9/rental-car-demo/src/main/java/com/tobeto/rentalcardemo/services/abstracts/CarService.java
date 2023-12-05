package com.tobeto.rentalcardemo.services.abstracts;

import com.tobeto.rentalcardemo.entity.Car;
import com.tobeto.rentalcardemo.services.dto.car.requests.AddCarRequest;
import com.tobeto.rentalcardemo.services.dto.car.responses.AddCarResponse;
import com.tobeto.rentalcardemo.services.dto.car.responses.GetAllCarResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {
    AddCarResponse add(AddCarRequest request);
    List<GetAllCarResponse> getAll();
    GetAllCarResponse getById(Integer carId);

    void delete(Integer carId);

    void update(Integer carId, AddCarRequest request);
    List<GetAllCarResponse> getModelYear(Integer modelYear);
    List<Car> getModelName(String modelName);
}
