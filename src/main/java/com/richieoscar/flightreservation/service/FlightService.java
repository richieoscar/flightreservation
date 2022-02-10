package com.richieoscar.flightreservation.service;

import com.richieoscar.flightreservation.model.Flight;

import java.util.Date;
import java.util.List;

public interface FlightService {

    Flight addFlight(Flight flight);

    List<Flight> findFlights(String from, String to, Date departureDate);

    void cancelFlight(Flight flight);
    
    Flight findFlight(Long id);

    List<Flight> getAllFlight();


}
