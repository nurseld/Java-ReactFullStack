package com.tobeto.rentalcardemo.services.dto.reservation.responses;

import lombok.Data;

import java.time.LocalDate;

@Data
public class GetAllReservationResponse {


    private LocalDate pickUpDate;

    private LocalDate dropOffDate;

    private String reservationStatus;
}
