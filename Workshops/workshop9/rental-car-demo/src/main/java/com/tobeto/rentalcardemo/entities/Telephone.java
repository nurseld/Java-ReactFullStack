package com.tobeto.rentalcardemo.entities;

import jakarta.persistence.*;

@Table(name = "telephones")
@Entity
public class Telephone {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int phoneId;

    @Column(name = "description")
    private String description;

    @Column(name = "value")
    private String phoneNumber;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer;



}