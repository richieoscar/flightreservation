package com.richieoscar.flightreservation.controller;

import com.richieoscar.flightreservation.dto.ReservationUpdateRequest;
import com.richieoscar.flightreservation.model.Reservation;
import com.richieoscar.flightreservation.repo.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
public class ReservationRestController {

    @Autowired
    ReservationRepository reservationRepository;

    @GetMapping("/reservations/{reservationId}")
    public Reservation getReservation(@PathVariable(value = "reservationId") Long id){
        Optional<Reservation> reservation = reservationRepository.findById(id);
        if(reservation.isPresent()){
            return reservation.get();
        }
        else {
            throw new IllegalStateException("No reservation found with ID: " +id);
        }
    }

    @RequestMapping("/reservations")
    public Reservation updateReservation(@RequestBody ReservationUpdateRequest request){
        Reservation reservation = reservationRepository.findById(request.getId()).get();
        reservation.setCheckedIn(request.getCheckedIn());
        reservation.setNumberOfBags(request.getNumberOfBags());
        return reservationRepository.save(reservation);
    }
}
