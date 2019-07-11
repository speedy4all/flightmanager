package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.FlightsRepository;
import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.dto.FlightAdapter;
import com.p5.flightmanager.service.dto.FlightDto;
import com.p5.flightmanager.service.exceptions.NoFlightException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.ws.rs.NotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightsRepository flightsRepository;

    private FlightAdapter flightadapter = new FlightAdapter();


    public List<FlightDto> getAll() {

        flightsRepository.findAll();

        return FlightAdapter.toListDto(flightsRepository.findAll());
    }

    @Override
    public FlightDto createFlight() {
        Flight newFlight = new Flight("First flight", "BUH", "CN", 8d, new Date(), new Date());
        Flight flight=flightsRepository.save(newFlight);
        return FlightAdapter.getFlightDto(flight);
    }

    private FlightDto toDto(Flight flight) {
        FlightDto flightdto=new FlightDto();
        flightdto.setName(flight.getName().toString());
        flightdto.setId(flight.getId().toString());
        flightdto.setDeaprtureLocation(flight.getDepartureLocation().toString());
        flightdto.setDestinationLocation(flight.getDestinationLocation().toString());
        flightdto.setFullFlightDescription(flight.getDepartureLocation().concat("-").concat(flight.getDestinationLocation()));


        return flightdto;
    }

    @Override
    public FlightDto getById(String id) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(id));
        if(optionalFlight.isPresent()){
        Flight flight=optionalFlight.get();

            FlightDto flightdto=new FlightDto();
            flightdto.setName(flight.getName().toString());
            flightdto.setId(flight.getId().toString());
            flightdto.setDeaprtureLocation(flight.getDepartureLocation().toString());
            flightdto.setDestinationLocation(flight.getDestinationLocation().toString());
            flightdto.setFullFlightDescription(flight.getDepartureLocation().concat("-").concat(flight.getDestinationLocation()));

        return flightdto;
    }



