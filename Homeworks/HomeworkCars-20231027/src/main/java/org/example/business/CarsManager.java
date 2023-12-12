package org.example.business;

import org.example.core.logging.Logger;
import org.example.dataAccess.CarsDao;
import org.example.entities.Cars;

import java.time.Year;
import java.util.List;

public class CarsManager {

    private CarsDao carsDao;

    private List<Logger> loggers;

    public CarsManager(CarsDao carsDao, List<Logger> loggers) {
        this.carsDao = carsDao;
        this.loggers = loggers;
    }

    public void add(Cars car) throws Exception{

        if (car == null) {
            throw new Exception("Araba nesnesi boş olamaz.");
        }

        int currentYear = Year.now().getValue();
        if (car.getYear() < 1900 || car.getYear() > currentYear) {
            throw new Exception("Geçersiz yıl değeri.");
        }

        if (car.getEnginePower() <= 0) {
            throw new Exception("Motor gücü sıfır veya negatif olamaz.");
        }

        if (car.getFuelType().equalsIgnoreCase("Elektrik") && car.getEngineCapacity() != 0) {
            throw new Exception("Elektrikli arabaların motor hacmi 0 olmalıdır.");
        }


        carsDao.add(car);

        for (Logger logger : loggers ) {
            logger.log(car.getBrand());


        }

    }


    public void updateCar(Cars car) throws Exception {
        if (car == null) {
            throw new Exception("Araba nesnesi boş olamaz.");
        }

        carsDao.updateCar(car);

        for (Logger logger : loggers ) {
            logger.log(car.getBrand());

        }

    }
    public void deleteCar(int id){
        carsDao.deleteCar(id);

        }

    }

