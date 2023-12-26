package com.tobeto.rentalcardemo.services.dto.reservation.responses;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllReservationResponse {

    private LocalDate pickUpDate;

    private LocalDate dropOffDate;

    private String reservationStatus;
}
