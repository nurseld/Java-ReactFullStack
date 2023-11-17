package com.tobeto.rentalcardemo.entities;

import jakarta.persistence.*;

@Table(name = "addresses")
@Entity
public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    @Column(name = "location_name")
    private String locationName;

    @Column(name = "country")
    private String countryName;

    @Column(name = "city")
    private String cityName;

    @Column(name = "district")
    private String districtName;

    @Column(name = "street")
    private String streetName;

    @Column(name = "post_code")
    private String postCode;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "car_id",unique = true)
    private Car car;


}