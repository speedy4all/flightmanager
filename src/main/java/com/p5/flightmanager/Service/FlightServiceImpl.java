package com.p5.flightmanager.Service;

import com.p5.flightmanager.Repository.FlightsRepository;
import com.p5.flightmanager.Repository.Models.Flight;
import com.p5.flightmanager.Service.api.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightsRepository flightsRepository;

    @Override
    public List<Flight> getAll(){

        List<Flight> flights = new ArrayList<>();
        flightsRepository.findAll().forEach(flights::add);
        return flights;
    }

    @Override
    public Flight createFlight() {
        Flight newFlight = new Flight("First flight", "BUN", "CN", 8d, new Date(), new Date());
        return flightsRepository.save(newFlight);
    }

    @Override
    public Flight getById(String id) {
        Optional<Flight> optionalFlight = flightsRepository.findById(id);
        if(optionalFlight.isPresent()){
            return optionalFlight.get();
        }
        return null;
    }
}
