package com.tobeto.rentalcardemo.services.dto.reservation.requests;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UpdateReservationRequest {

    @NotNull(message = "Reservation ID cannot be null")
    @Positive(message = "Reservation ID must be a positive number")
    private Integer reservationId;

    @NotNull(message = "Pick-up date cannot be null")
    private LocalDate pickUpDate;

    @NotNull(message = "Drop-off date cannot be null")
    private LocalDate dropOffDate;

    @NotBlank(message = "Reservation status cannot be blank")
    private String reservationStatus;
}
