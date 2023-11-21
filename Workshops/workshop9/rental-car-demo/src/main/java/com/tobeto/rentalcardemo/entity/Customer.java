package com.tobeto.rentalcardemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "customers")
@Entity
@Getter
@Setter
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


    @JsonIgnoreProperties("customer")
    @OneToMany(mappedBy = "customer")
    private List<Telephone> telephone;

    @JsonIgnoreProperties("customer")
    @OneToMany(mappedBy = "customer")
    private List<Address> address;

    @JsonIgnoreProperties("customer")
    @OneToMany(mappedBy = "customer")
    private List<Reservation> reservation;


}
