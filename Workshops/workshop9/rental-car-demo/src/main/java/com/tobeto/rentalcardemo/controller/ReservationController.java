package com.tobeto.rentalcardemo.controller;

import com.tobeto.rentalcardemo.dto.ReservationRequest;
import com.tobeto.rentalcardemo.entity.Reservation;
import com.tobeto.rentalcardemo.repository.ReservationRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationRepository reservationRepository;

    public ReservationController(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @PostMapping
    public String create(@RequestBody Reservation reservation){

        reservationRepository.save(reservation);
        return "Reservation has been saved to DB.";
    }

    @GetMapping
    public List<Reservation> getAll(){

        return reservationRepository.findAll();
    }

    @GetMapping("/{reservationId}")
    public Reservation getById(@RequestParam Integer reservationId){

        return reservationRepository.findById(reservationId)
                .orElseThrow(() -> new RuntimeException("Reservation does not exist."));
    }

    @DeleteMapping("/{reservationId}")
    public void delete(@RequestParam Integer reservationId){

        reservationRepository.deleteById(reservationId);
    }

    @PutMapping
    public void update(@RequestBody ReservationRequest request){

        Reservation reservationInDb = reservationRepository.findById(request.getReservationId())
                .orElseThrow(()-> new RuntimeException("Reservation does not exist."));

        reservationInDb.setReservationStatus(request.getReservationStatus());
        reservationInDb.setPickUpDate(request.getPickUpDate());
        reservationInDb.setDropOffDate(request.getDropOffDate());

        reservationRepository.save(reservationInDb);
    }
}
