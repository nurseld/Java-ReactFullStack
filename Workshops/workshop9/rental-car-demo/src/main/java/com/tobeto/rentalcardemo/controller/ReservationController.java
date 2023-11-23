package com.tobeto.rentalcardemo.controller;

import com.tobeto.rentalcardemo.services.abstracts.ReservationService;
import com.tobeto.rentalcardemo.services.dto.reservation.requests.AddReservationRequest;
import com.tobeto.rentalcardemo.services.dto.reservation.responses.AddReservationResponse;
import com.tobeto.rentalcardemo.services.dto.reservation.responses.GetAllReservationResponse;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService reservationService;

    public ReservationController(ReservationService reservationService) {
        this.reservationService = reservationService;
    }


    @PostMapping
    public AddReservationResponse add(@RequestBody AddReservationRequest request){

        return reservationService.add(request);
    }

    @GetMapping
    public List<GetAllReservationResponse> getAll(){

        return reservationService.getAll();
    }

    @GetMapping("/{reservationId}")
    public GetAllReservationResponse getById(@PathVariable Integer reservationId){

        return reservationService.getById(reservationId);
    }

    @DeleteMapping("/{reservationId}")
    public void delete(@PathVariable Integer reservationId){

        reservationService.delete(reservationId);
    }

    @PutMapping("/{reservationId}")
    public void update(@PathVariable Integer reservationId, @RequestBody AddReservationRequest request){

        reservationService.update(reservationId,request);
    }
}
