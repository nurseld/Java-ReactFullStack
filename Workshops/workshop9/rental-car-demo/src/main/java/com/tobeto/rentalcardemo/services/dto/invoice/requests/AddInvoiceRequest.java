package com.tobeto.rentalcardemo.services.dto.invoice.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddInvoiceRequest {

    private double totalPrice;

    private LocalDate paymentDateTime;

    private String paymentMethod;
}
