package com.tobeto.rentalcardemo.services.dto.reservation.requests;

import lombok.Data;

import java.time.LocalDate;

@Data
public class AddReservationRequest {
    private int reservationId;

    private LocalDate pickUpDate;

    private LocalDate dropOffDate;

    private String reservationStatus;
}
