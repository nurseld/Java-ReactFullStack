package com.tobeto.rentalcardemo.entities.concretes;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.tobeto.rentalcardemo.entities.abstarcts.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "invoices")
@Entity
@Getter
@Setter
public class Invoice extends BaseEntity {


    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "payment_date_time")
    private LocalDate paymentDateTime;

    @Column(name = "payment_method")
    private String paymentMethod;

    @JsonIgnoreProperties("reservation")
    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;


}
