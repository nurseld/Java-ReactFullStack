package com.tobeto.rentalcardemo.services.dto.invoice.responses;

import lombok.Data;

@Data
public class GetAllInvoiceResponse {

    private double totalPrice;

   // private LocalDate paymentDateTime;

    private String paymentMethod;
}
