package com.tobeto.rentalcardemo.services.concretes;

import com.tobeto.rentalcardemo.entity.Car;
import com.tobeto.rentalcardemo.repository.CarRepository;
import com.tobeto.rentalcardemo.services.abstracts.CarService;
import com.tobeto.rentalcardemo.services.dto.car.requests.AddCarRequest;
import com.tobeto.rentalcardemo.services.dto.car.responses.AddCarResponse;
import com.tobeto.rentalcardemo.services.dto.car.responses.GetAllCarResponse;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarManager implements CarService {


    private final CarRepository carRepository;

    public CarManager(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public AddCarResponse add(AddCarRequest request) {

        Car car = new Car();

        car.setBrandName(request.getBrandName());
        car.setModelName(request.getModelName());
        car.setModelYear(request.getModelYear());
        car.setFuelType(request.getFuelType());
        car.setGearType(request.getGearType());
        car.setDailyPrice(request.getDailyPrice());

        Car savedCar = carRepository.save(car);
        AddCarResponse response = new AddCarResponse();
        response.setId(savedCar.getId());
        return response;
    }

    @Override
    public List<GetAllCarResponse> getAll() {

        List<Car> carList = carRepository.findAll();
        List<GetAllCarResponse> responses = new ArrayList<>();

        for (Car car : carList) {

            GetAllCarResponse response = new GetAllCarResponse();

            response.setBrandName(car.getBrandName());
            response.setModelName(car.getModelName());
            response.setModelYear(car.getModelYear());
            response.setGearType(car.getGearType());
            response.setFuelType(car.getFuelType());
            response.setDailyPrice(car.getDailyPrice());

            responses.add(response);

        }

        return responses;
    }

    @Override
    public GetAllCarResponse getById(Integer carId) {

        Car carInDb = carRepository.findById(carId)
                .orElseThrow(()-> new RuntimeException("Car does not exist."));

        GetAllCarResponse response = new GetAllCarResponse();

        response.setBrandName(carInDb.getBrandName());
        response.setModelName(carInDb.getModelName());
        response.setModelYear(carInDb.getModelYear());
        response.setGearType(carInDb.getGearType());
        response.setFuelType(carInDb.getFuelType());
        response.setDailyPrice(carInDb.getDailyPrice());

        return response;
    }

    @Override
    public void delete(Integer carId) {

        carRepository.deleteById(carId);

    }

    @Override
    public void update(Integer carId, AddCarRequest request) {

        Car car = carRepository.findById(carId)
                .orElseThrow(()-> new RuntimeException("Car does not exist."));

        car.setBrandName(request.getBrandName());
        car.setModelName(request.getModelName());
        car.setModelYear(request.getModelYear());
        car.setGearType(request.getGearType());
        car.setFuelType(request.getFuelType());
        car.setDailyPrice(request.getDailyPrice());

        carRepository.save(car);
    }

    @Override
    public List<GetAllCarResponse> getModelYear(String modelYear) {

        return carRepository.findModelYear(modelYear);

    }

    @Override
    public List<Car> getModelName(String modelName) {

        return carRepository.findByModelName(modelName);
    }


}
