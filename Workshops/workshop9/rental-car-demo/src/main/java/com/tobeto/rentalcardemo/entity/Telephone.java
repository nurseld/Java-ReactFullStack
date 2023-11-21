package com.tobeto.rentalcardemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "telephones")
@Entity
@Getter
@Setter
public class Telephone {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int phoneId;

    @Column(name = "description")
    private String description;

    @Column(name = "value",unique = true)
    private String phoneNumber;

    @ManyToOne
    @JsonIgnoreProperties("telephone")
    @JoinColumn(name = "customer_id")
    private Customer customer;



}