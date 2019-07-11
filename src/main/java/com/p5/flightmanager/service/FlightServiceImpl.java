package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.FlightsRepository;
import com.p5.flightmanager.service.api.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightsRepository flightsRepository;


    public List<Flight> getAll() {

        List<Flight> flights = new ArrayList<>();
        flightsRepository.findAll().forEach(flights::add);
        return flights;
    }

    @Override
    public Flight createFlight() {
        Flight newFlight = new Flight("First flight", "BUH", "CN", 8d, new Date(), new Date());

        return flightsRepository.save(newFlight);
    }

    @Override
    public Flight getById(String id) {
        Optional<Flight> optionalFlight = flightsRepository.findById(id);
        if(optionalFlight.isPresent()) {
            return optionalFlight.get();
        }
        return null;
    }
}