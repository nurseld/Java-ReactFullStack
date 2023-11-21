package com.tobeto.rentalcardemo.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class ReservationRequest {

    private int reservationId;

    private LocalDate pickUpDate;

    private LocalDate dropOffDate;

    private String reservationStatus;

}
