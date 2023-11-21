package com.tobeto.rentalcardemo.controller;

import com.tobeto.rentalcardemo.dto.CarRequest;
import com.tobeto.rentalcardemo.entity.Car;
import com.tobeto.rentalcardemo.repository.CarRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cars")
public class CarController {

    private final CarRepository carRepository;

    public CarController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @PostMapping
    public String create(@RequestBody Car car){

        carRepository.save(car);
        return "Car has been saved to DB.";
    }

    @GetMapping
    public List<Car> getAll(){

        return carRepository.findAll();
    }

    @GetMapping("/{carId}")
    public Car getById(@RequestParam Integer carId){

        return carRepository.findById(carId)
                .orElseThrow(() -> new RuntimeException("Car does not exist."));
    }

    @DeleteMapping("/{carId}")
    public void delete(@RequestParam Integer carId){

        carRepository.deleteById(carId);
    }

    @PutMapping
    public void update(@RequestBody CarRequest request){

        Car carInDb = carRepository.findById(request.getId())
                .orElseThrow(()-> new RuntimeException("Car does not exist."));

        carInDb.setBrandName(request.getBrandName());
        carInDb.setModelName(request.getModelName());
        carInDb.setModelYear(request.getModelYear());
        carInDb.setFuelType(request.getFuelType());
        carInDb.setGearType(request.getGearType());
        carInDb.setDailyPrice(request.getDailyPrice());

        carRepository.save(carInDb);
    }
}
