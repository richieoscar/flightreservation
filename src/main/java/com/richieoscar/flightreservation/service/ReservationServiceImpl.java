package com.richieoscar.flightreservation.service;

import com.richieoscar.flightreservation.dto.ReservationRequest;
import com.richieoscar.flightreservation.model.Flight;
import com.richieoscar.flightreservation.model.Passenger;
import com.richieoscar.flightreservation.model.Reservation;
import com.richieoscar.flightreservation.repo.FlightRepository;
import com.richieoscar.flightreservation.repo.PassengerRepository;
import com.richieoscar.flightreservation.repo.ReservationRepository;
import com.richieoscar.flightreservation.util.EmailUtil;
import com.richieoscar.flightreservation.util.PDFGenerator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class ReservationServiceImpl implements ReservationService {
    @Autowired
    FlightService service;

    @Autowired
    FlightRepository flightRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Autowired
    PDFGenerator pdfGenerator;

    @Autowired
    EmailUtil emailUtil;


    @Override
    public Flight completeReservation(Long id) {
        return service.findFlight(id);

    }

    @Override
    @Transactional
    public Reservation bookFlight(ReservationRequest reservationRequest) {
        //make payment will be done later

        Long flightId = reservationRequest.getFlightId();
        Flight flight = flightRepository.findById(flightId).get();

            //create passenger and supply information from request
        Passenger passenger = new Passenger();
        passenger.setFirsName(reservationRequest.getPassengerFirstName());
        passenger.setLastName(reservationRequest.getPassengerLastName());
        passenger.setEmail(reservationRequest.getPassengerEmail());
        passenger.setPhone(reservationRequest.getPassengerPhone());
        Passenger savedPassenger = passengerRepository.save(passenger);

        System.out.println(savedPassenger);

        //create reservation and supply reservation information
        Reservation reservation = new Reservation();
        reservation.setFlight(flight);
        reservation.setPassenger(savedPassenger);
        reservation.setCheckedIn(false);

        //save reservation
        Reservation savedReservation = reservationRepository.save(reservation);
        String filePath = "C:\\Users\\NAJCOM LAPTOP 4\\Documents\\reservations\\reservation" + savedReservation.getId() + ".pdf";
        pdfGenerator.generateItenary(savedReservation, filePath);
        emailUtil.sendItenary(savedReservation.getPassenger().getEmail(), filePath);
        return  savedReservation;
    }
}
