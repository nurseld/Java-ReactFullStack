package com.tobeto.rentalcardemo.entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "customers")
@Entity
public class Customer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int customerId;

    @Column(name = "name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "surname")
    private String surName;

    @Column(name = "age")
    private int age;

    @Column(name = "citizenship_id")
    private String citizenShipId;

    @OneToMany(mappedBy = "customer")
    private List<Telephone> telephone;

    @OneToMany(mappedBy = "customer")
    private List<Address> address;

    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservation;


}
