package com.tobeto.rentalcardemo.controller;

import com.tobeto.rentalcardemo.entity.Car;
import com.tobeto.rentalcardemo.services.abstracts.CarService;
import com.tobeto.rentalcardemo.services.dto.car.requests.AddCarRequest;
import com.tobeto.rentalcardemo.services.dto.car.requests.UpdateCarRequest;
import com.tobeto.rentalcardemo.services.dto.car.responses.AddCarResponse;
import com.tobeto.rentalcardemo.services.dto.car.responses.GetAllCarResponse;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping
    public AddCarResponse add(@RequestBody @Valid AddCarRequest request){

        return carService.add(request);
    }

    @GetMapping
    public List<GetAllCarResponse> getAll(){

        return carService.getAll();
    }

    @GetMapping("/{carId}")
    public GetAllCarResponse getById(@PathVariable Integer carId){

        return carService.getById(carId);

    }

    @DeleteMapping("/{carId}")
    public void delete(@PathVariable  Integer carId){

        carService.delete(carId);
    }

    @PutMapping("/{carId}")
    public void update(@PathVariable Integer carId, @RequestBody @Valid UpdateCarRequest request){

        carService.update(carId,request);
    }

    @GetMapping("modelYear")
    public List<GetAllCarResponse> getModelYear(@RequestParam Integer modelYear){

        return carService.getModelYear(modelYear);
    }


    @GetMapping("modelName")
    public List<Car> getModelName(@RequestParam String modelName){

        return carService.getModelName(modelName);
  }
}
