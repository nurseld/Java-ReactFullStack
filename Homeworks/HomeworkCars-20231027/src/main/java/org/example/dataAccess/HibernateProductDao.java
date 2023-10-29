package org.example.dataAccess;

import org.example.entities.Cars;

public class HibernateProductDao implements CarsDao {

    public void add(Cars car){
        System.out.println("Added car database with Hibernate");

    }

    @Override
    public void deleteCar(int id) {
        System.out.println("Deleted car from the database with Hibernate");
    }

    @Override
    public void updateCar(Cars car) {
        System.out.println("Updated in the car database with Hibernate");
    }
}
