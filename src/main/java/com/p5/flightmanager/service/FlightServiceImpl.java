package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.FlightsRepository;
import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.dto.FlightDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;

@Component
public class FlightServiceImpl implements FlightService {
    @Autowired
    private FlightsRepository flightsRepository;

    public List<Flight> getAll() {

        List<Flight>flights = new ArrayList<>();
        flightsRepository.findAll().forEach(flights::add);
        return flights;
    }

    @Override
    public FlightDto createFlight() {
        Flight newFlight = new Flight("First flight", "BUH", "CN", 8d, new Date(), new Date());
        Flight flight = flightsRepository.save(newFlight);
        FlightDto flightDto = new FlightDto();
        flightDto.setId(flight.getId().toString());
        //flightDto.setName(flight.getName());
        //.setDepartureLocation(flight.getDepartureLocation());
       // flightDto.setDestinationLocation(flight.getDestinationLocation());

        //flightDto.setFullFlightDescription(flight.getDepartureLocation().concat("-").concat(flight.getDestinationLocation()));
        return  null;
    }
    //getFlightDto

    @Override
    public Flight getById(String id) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(id));
        if(optionalFlight.isPresent()) {
            return optionalFlight.get();
        }
        throw new NoFlightException();
    }
}
