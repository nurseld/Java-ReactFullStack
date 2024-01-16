package com.tobeto.rentalcardemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tobeto.rentalcardemo.entities.abstarcts.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Table(name = "addresses")
@Entity
@Getter
@Setter
public class Address extends BaseEntity {


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