package com.tobeto.rentalcardemo.services.dto.invoice.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AddInvoiceRequest {

    @Positive(message = "Total price must be a positive number")
    private double totalPrice;

    @NotNull(message = "Payment date and time cannot be null")
    private LocalDate paymentDateTime;

    @NotBlank(message = "Payment method cannot be blank")
    private String paymentMethod;


}
