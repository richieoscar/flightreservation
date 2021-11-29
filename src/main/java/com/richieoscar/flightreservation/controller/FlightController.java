package com.richieoscar.flightreservation.controller;

import com.richieoscar.flightreservation.model.Flight;
import com.richieoscar.flightreservation.service.FlightService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
public class FlightController {

    @Autowired
    FlightService flightService;

    private static final Logger LOGGER = LoggerFactory.getLogger(FlightController.class);

    @PostMapping("/findFlights")
    public String findFlights(@RequestParam("from") String from, @RequestParam("to") String to,
                              @RequestParam("departureDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
                                      Date departureDate, Model model){
        List<Flight> flights = flightService.findFlights(from, to, departureDate);
        model.addAttribute("flights", flights);
        model.addAttribute("noFlights", "No Flights Found");
        logInfo("Finf FLights returns:" +flights);
        return "dashboard";
    }

    @RequestMapping("/admin/showAddFlight")
    public String showAddFlights(){
        return "addFlights";
    }

    private void logInfo(String info){
        LOGGER.info(info);
    }
    private void logError(String error){
        LOGGER.error(error);
    }

}
