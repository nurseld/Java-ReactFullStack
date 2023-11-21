package com.tobeto.rentalcardemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class InvoiceRequest {

    private int invoiceId;

    private double totalPrice;

    private LocalDate paymentDateTime;

    private String paymentMethod;

}
