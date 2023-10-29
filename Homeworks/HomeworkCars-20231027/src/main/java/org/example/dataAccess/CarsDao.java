package org.example.dataAccess;

import org.example.entities.Cars;

public interface CarsDao {

    void add(Cars car);

    void deleteCar(int id);

    void updateCar(Cars car);
}
