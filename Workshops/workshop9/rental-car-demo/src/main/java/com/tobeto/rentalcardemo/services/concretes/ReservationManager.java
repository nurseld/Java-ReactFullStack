package com.tobeto.rentalcardemo.services.concretes;

import com.tobeto.rentalcardemo.entity.Reservation;
import com.tobeto.rentalcardemo.repository.ReservationRepository;
import com.tobeto.rentalcardemo.services.abstracts.ReservationService;
import com.tobeto.rentalcardemo.services.dto.reservation.requests.AddReservationRequest;
import com.tobeto.rentalcardemo.services.dto.reservation.responses.AddReservationResponse;
import com.tobeto.rentalcardemo.services.dto.reservation.responses.GetAllReservationResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class ReservationManager implements ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationManager(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }


    @Override
    public AddReservationResponse add(AddReservationRequest request) {

        Reservation reservation = new Reservation();

        reservation.setPickUpDate(request.getPickUpDate());
        reservation.setDropOffDate(request.getDropOffDate());
        reservation.setReservationStatus(request.getReservationStatus());

        Reservation savedReservation = reservationRepository.save(reservation);
        AddReservationResponse response = new AddReservationResponse();
        response.setId(savedReservation.getReservationId());
        return response;
    }

    @Override
    public List<GetAllReservationResponse> getAll() {

/*        List<Reservation> reservationList = reservationRepository.findAll();

        List<GetAllReservationResponse> responses = new ArrayList<>();

        for (Reservation reservation : reservationList) {

            GetAllReservationResponse response = new GetAllReservationResponse();

            response.setPickUpDate(reservation.getPickUpDate());
            response.setDropOffDate(reservation.getDropOffDate());
            response.setReservationStatus(reservation.getReservationStatus());

            responses.add(response);

        }

        return responses;*/

        return reservationRepository.findAll()
                .stream()
                .map(reservation -> new GetAllReservationResponse(reservation.getPickUpDate(),reservation.getDropOffDate(),reservation.getReservationStatus())).toList();
    }

    @Override
    public GetAllReservationResponse getById(Integer reservationId) {

        Reservation reservationInDb = reservationRepository.findById(reservationId)
                .orElseThrow(()-> new RuntimeException("Reservation does not exist."));

        GetAllReservationResponse response = new GetAllReservationResponse();

        response.setPickUpDate(reservationInDb.getPickUpDate());
        response.setDropOffDate(reservationInDb.getDropOffDate());
        response.setReservationStatus(response.getReservationStatus());

        return response;
    }

    @Override
    public void delete(Integer reservationId) {

        reservationRepository.deleteById(reservationId);
    }

    @Override
    public void update(Integer reservationId, AddReservationRequest request) {

        Reservation reservation = reservationRepository.findById(reservationId)
                .orElseThrow(()-> new RuntimeException("Reservation does not exist."));

        reservation.setPickUpDate(request.getPickUpDate());
        reservation.setDropOffDate(request.getDropOffDate());
        reservation.setReservationStatus(request.getReservationStatus());

        reservationRepository.save(reservation);

    }

    @Override
    public List<Reservation> getReservationStatus(String status) {

        return reservationRepository.findByReservationStatus(status);
    }

    @Override
    public List<GetAllReservationResponse> getDropOffDateBefore(LocalDate dropOffDate) {

        //return reservationRepository.findDropOffDateBefore(dropOffDate);
        return reservationRepository.findDropOffDateBefore(dropOffDate).stream()
                .map(reservation -> new GetAllReservationResponse(reservation.getPickUpDate(),
                        reservation.getDropOffDate(),
                        reservation.getReservationStatus()))
                .toList();
    }
}
