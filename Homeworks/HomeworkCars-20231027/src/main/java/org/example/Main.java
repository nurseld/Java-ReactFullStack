package org.example;

import org.example.business.CarsManager;
import org.example.core.logging.DatabaseLogger;
import org.example.core.logging.FileLogger;
import org.example.core.logging.Logger;
import org.example.core.logging.MailLogger;
import org.example.dataAccess.JdbcCarsDao;
import org.example.entities.Cars;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws Exception {

        Cars car1 = new Cars(1,"Togg","Electric-X","SUV",
                2023,"Elektrik","Otomatik",200,0,"Kula");

        List<Logger> loggers = new ArrayList<>();
        loggers.add(new DatabaseLogger());
        loggers.add(new FileLogger());
        loggers.add(new MailLogger());

        CarsManager carsManager = new CarsManager(new JdbcCarsDao(),loggers);
        carsManager.add(car1);



    }
}