package com.tobeto.rentalcardemo.services.dto.invoice.requests;

import lombok.Data;

@Data
public class AddInvoiceRequest {

    private double totalPrice;

    //private LocalDate paymentDateTime;

    private String paymentMethod;
}
