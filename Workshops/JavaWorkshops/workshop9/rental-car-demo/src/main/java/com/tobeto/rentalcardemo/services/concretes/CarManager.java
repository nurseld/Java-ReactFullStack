package com.tobeto.rentalcardemo.services.concretes;

import com.tobeto.rentalcardemo.core.utilities.exceptions.BusinessException;
import com.tobeto.rentalcardemo.entity.Car;
import com.tobeto.rentalcardemo.repository.CarRepository;
import com.tobeto.rentalcardemo.services.abstracts.CarService;
import com.tobeto.rentalcardemo.services.dto.car.requests.AddCarRequest;
import com.tobeto.rentalcardemo.services.dto.car.requests.UpdateCarRequest;
import com.tobeto.rentalcardemo.services.dto.car.responses.AddCarResponse;
import com.tobeto.rentalcardemo.services.dto.car.responses.GetAllCarResponse;
import org.springframework.stereotype.Service;

import java.time.Year;
import java.util.List;

@Service
public class CarManager implements CarService {


    private final CarRepository carRepository;

    public CarManager(CarRepository carRepository) {
        this.carRepository = carRepository;
    }


    @Override
    public AddCarResponse add(AddCarRequest request) {


        int currentYear = Year.now().getValue();
        if (request.getModelYear() < 2000 || request.getModelYear() > currentYear) {
            throw new BusinessException("Invalid model year.");
        }

        if ("Elektrik".equalsIgnoreCase(request.getFuelType()) && request.getModelYear() < 2015) {
            throw new BusinessException("The model year of electric vehicles must be at least 2015.");
        }

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

/*        List<Car> carList = carRepository.findAll();
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

        return responses;*/

        return carRepository.findAll()
                .stream()
                .map(car -> new GetAllCarResponse(
                        car.getBrandName(),
                        car.getModelName(),
                        car.getModelYear(),
                        car.getGearType(),
                        car.getFuelType(),
                        car.getDailyPrice()
                ))
                .toList();

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
    public void update(Integer carId, UpdateCarRequest request) {

        Car car = carRepository.findById(carId).orElseThrow(()-> new RuntimeException("Car does not exist."));

        car.setBrandName(request.getBrandName());
        car.setModelName(request.getModelName());
        car.setModelYear(request.getModelYear());
        car.setGearType(request.getGearType());
        car.setFuelType(request.getFuelType());
        car.setDailyPrice(request.getDailyPrice());

        carRepository.save(car);
    }

    @Override
    public List<GetAllCarResponse> getModelYear(Integer modelYear) {

        return carRepository.findModelYear(modelYear)
                .stream()
                .map((car) -> {
                    return new GetAllCarResponse(car.getBrandName(),
                            car.getModelName(),
                            car.getModelYear(),
                            car.getFuelType(),
                            car.getGearType(),
                            car.getDailyPrice());
                }).toList();
    }

    @Override
    public List<Car> getModelName(String modelName) {

        return carRepository.findByModelName(modelName);
    }


}
