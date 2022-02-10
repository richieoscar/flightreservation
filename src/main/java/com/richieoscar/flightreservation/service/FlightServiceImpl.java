package com.richieoscar.flightreservation.service;

import com.richieoscar.flightreservation.controller.UserController;
import com.richieoscar.flightreservation.model.Flight;
import com.richieoscar.flightreservation.repo.FlightRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class FlightServiceImpl implements FlightService {


    FlightRepository flightRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightServiceImpl.class);

    @Override
    public Flight addFlight(Flight flight) {
        return flightRepository.save(flight);
    }

    @Override
    public List<Flight> findFlights(String from, String to, Date departureDate) {
        return flightRepository.findFlights(from, to, departureDate);
    }

    @Override
    public void cancelFlight(Flight flight) {
        flightRepository.delete(flight);

    }

    @Override
    public Flight findFlight(Long id) {
        Optional<Flight> flight = flightRepository.findById(id);
        if (flight.isPresent()) {
            logInfo("Find flight returns: "+flight);
            return flight.get();
        } else throw new IllegalStateException("No Record found for flight with " + id);
    }

    @Override
    public List<Flight> getAllFlight() {
        return flightRepository.findAll();
    }

    private void logInfo(String info){
        LOGGER.info(info);
    }
    private void logError(String error){
        LOGGER.error(error);
    }
}
