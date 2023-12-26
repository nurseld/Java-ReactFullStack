package com.tobeto.rentalcardemo.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Table(name = "invoices")
@Entity
@Getter
@Setter
public class Invoice {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceId;

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
