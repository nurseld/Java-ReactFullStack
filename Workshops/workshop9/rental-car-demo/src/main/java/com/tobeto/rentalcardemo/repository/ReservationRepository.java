package com.tobeto.rentalcardemo.repository;

import com.tobeto.rentalcardemo.entity.Reservation;
import com.tobeto.rentalcardemo.services.dto.reservation.responses.GetAllReservationResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface ReservationRepository  extends JpaRepository<Reservation, Integer> {
    List<Reservation> findByReservationStatus(String status);

    @Query("Select new com.tobeto.rentalcardemo.services.dto.reservation.responses.GetAllReservationResponse(r.pickUpDate,r.dropOffDate,r.reservationStatus) " +
            "FROM Reservation r WHERE r.dropOffDate < :dropOffDate")
    List<GetAllReservationResponse> findDropOffDateBefore(LocalDate dropOffDate);
}
