package com.tobeto.rentalcardemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tobeto.rentalcardemo.entities.abstarcts.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Table(name = "customers")
@Entity
@Getter
@Setter
public class Customer extends BaseEntity {


    @Column(name = "name")
    private String firstName;

    @Column(name = "middle_name")
    private String middleName;

    @Column(name = "surname")
    private String surName;

    @Column(name = "age")
    private Integer age;

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
