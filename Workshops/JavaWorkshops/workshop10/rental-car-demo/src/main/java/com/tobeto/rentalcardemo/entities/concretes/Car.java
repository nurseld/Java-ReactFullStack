package com.tobeto.rentalcardemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tobeto.rentalcardemo.entities.abstarcts.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Table(name = "cars")
@Entity
@Getter
@Setter
public class Car extends BaseEntity {


    @Column(name = "brand")
    private String brandName;

    @Column(name = "model")
    private String modelName;

    @Column(name = "year")
    private Integer modelYear;

    @Column(name = "fuel_type")
    private String fuelType;

    @Column(name = "gear_type")
    private String gearType;

    @Column(name = "price")
    private double dailyPrice;

    @JsonIgnoreProperties("car")
    @OneToMany(mappedBy = "car")
    private List<Reservation> reservations;


    @JsonIgnoreProperties("car")
    @OneToOne
    @JoinColumn(name = "address_id")
    private Address address;

}
