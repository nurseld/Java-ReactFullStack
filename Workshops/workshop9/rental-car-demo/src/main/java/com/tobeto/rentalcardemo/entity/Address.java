package com.tobeto.rentalcardemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "addresses")
@Entity
@Getter
@Setter
public class Address {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer addressId;

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
    @JsonIgnoreProperties("address")
    @JoinColumn(name = "customer_id")
    private Customer customer;


    @JsonIgnoreProperties("address")
    @OneToOne(mappedBy = "address")
    private Car car;


}