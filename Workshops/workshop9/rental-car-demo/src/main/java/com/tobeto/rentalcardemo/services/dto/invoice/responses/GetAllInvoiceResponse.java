package com.tobeto.rentalcardemo.services.dto.invoice.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class GetAllInvoiceResponse {

    private double totalPrice;

    private LocalDate paymentDateTime;

    private String paymentMethod;
}
