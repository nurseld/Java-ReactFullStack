package com.tobeto.rentalcardemo.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Table(name = "invoices")
@Entity
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

    @OneToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;


}
