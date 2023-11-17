package com.tobeto.rentalcardemo.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "cars")
@Entity
public class Car {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    @Column(name = "brand")
    private String brandName;

    @Column(name = "model")
    private String modelName;

    @Column(name = "year")
    private int modelYear;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "gear_type")
    private String gearType;

    @Column(name = "price")
    private double dailyPrice;

    @OneToMany(mappedBy = "car")
    private List<Reservation> reservation;

    @OneToMany(mappedBy = "car")
    private List<Address> address;

}
