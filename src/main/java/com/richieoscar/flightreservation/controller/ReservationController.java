package com.richieoscar.flightreservation.controller;

import com.richieoscar.flightreservation.dto.ReservationRequest;
import com.richieoscar.flightreservation.model.Flight;
import com.richieoscar.flightreservation.model.Reservation;
import com.richieoscar.flightreservation.service.ReservationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ReservationController {
    
    @Autowired
    ReservationService reservationService;

    private static final Logger LOGGER = LoggerFactory.getLogger(ReservationController.class);

    @RequestMapping("/completeReservation")
    public String viewFlight(@RequestParam("id") Long id, Model model){
        Flight flight = reservationService.completeReservation(id);
        model.addAttribute("flight", flight);
        return "completeReservation";
    }
    @PostMapping("/confirmReservation")
    public String confirmReservation(@ModelAttribute ReservationRequest reservationRequest, Model model){
        Reservation reservation = reservationService.bookFlight(reservationRequest);
        model.addAttribute("message", "Reservation created Successfully " +reservation.getId());
            logInfo("Confirm Reservation returns:" +reservation);
        return "reservationConfirmation";
    }

    private void logInfo(String info){
        LOGGER.info(info);
    }
    private void logError(String error){
        LOGGER.error(error);
    }
}
