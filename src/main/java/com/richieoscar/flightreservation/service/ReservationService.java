package com.richieoscar.flightreservation.service;

import com.richieoscar.flightreservation.dto.ReservationRequest;
import com.richieoscar.flightreservation.model.Flight;
import com.richieoscar.flightreservation.model.Reservation;
import org.springframework.stereotype.Service;

public interface ReservationService {
    
    Flight completeReservation(Long id);

    Reservation bookFlight(ReservationRequest reservationRequest);
}
