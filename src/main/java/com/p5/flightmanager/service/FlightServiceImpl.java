package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.FlightsRepository;
import com.p5.flightmanager.service.api.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightsRepository flightsRepository;

    @Override
    public List<Flight> getAll() {

        List<Flight> flights = new ArrayList<>();
        flightsRepository.findAll().forEach(flights::add);
        return flights;
    }

    @Override
    public Flight createFlight() {
        Flight newFlight = new Flight("First Flight", "BUC", "CH", 8d, new Date(), new Date());
        return flightsRepository.save(newFlight);
    }
}
