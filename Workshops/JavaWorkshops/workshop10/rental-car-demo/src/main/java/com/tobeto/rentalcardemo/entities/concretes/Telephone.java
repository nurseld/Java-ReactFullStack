package com.tobeto.rentalcardemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tobeto.rentalcardemo.entities.abstarcts.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "telephones")
@Entity
@Getter
@Setter
public class Telephone extends BaseEntity {


    @Column(name = "description")
    private String description;

    @Column(name = "value",unique = true)
    private String phoneNumber;

    @ManyToOne
    @JsonIgnoreProperties("telephone")
    @JoinColumn(name = "customer_id")
    private Customer customer;



}