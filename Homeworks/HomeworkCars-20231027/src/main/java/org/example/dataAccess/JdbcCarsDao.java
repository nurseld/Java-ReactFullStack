package org.example.dataAccess;

import org.example.entities.Cars;
public class JdbcCarsDao implements CarsDao {

    public void add(Cars car){
        System.out.println("Added car database with JDBC");

    }

    @Override
    public void deleteCar(int id) {
        System.out.println("Deleted car from the database with JDBC");
    }

    @Override
    public void updateCar(Cars car) {
        System.out.println("Updated in the car database with JDBC");
    }
}
