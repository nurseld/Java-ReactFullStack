package com.tobeto.rentalcardemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tobeto.rentalcardemo.entities.abstarcts.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "reservations")
@Entity
@Getter
@Setter
public class Reservation extends BaseEntity {


    @Column(name = "pick_up_date")
    private LocalDate pickUpDate;

    @Column(name = "drop_off_date")
    private LocalDate dropOffDate;

    @Column(name = "status")
    private String reservationStatus;

    @ManyToOne
    @JsonIgnoreProperties("reservation")
    @JoinColumn(name = "customer_id")
    private Customer customer;

    @ManyToOne()
    @JsonIgnoreProperties("reservation")
    @JoinColumn(name = "car_id")
    private Car car;

    @JsonIgnoreProperties("reservation")
    @OneToOne(mappedBy = "reservation")
    private Invoice invoice;
}
