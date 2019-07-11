package com.p5.flightmanager.Service;

import com.p5.flightmanager.Service.Dto.FlightAdapter;
import com.p5.flightmanager.Service.Dto.FlightDto;
import com.p5.flightmanager.Service.Exceptions.NoFlightException;
import com.p5.flightmanager.Repository.Models.Flight;
import com.p5.flightmanager.Repository.FlightsRepository;
import com.p5.flightmanager.Service.api.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightsRepository flightsRepository;

    public List<FlightDto> getAll() {
        return FlightAdapter.toListDto(flightsRepository.findAll());
    }

    @Override
    public FlightDto createFlight() {
        Flight newFlight = new Flight("First flight", "BUH", "CN", 8d, new Date(), new Date());
        Flight flight = flightsRepository.save(newFlight);
        FlightDto flightDto = new FlightDto();
        flightDto.setId(flight.getId().toString());
        flightDto.setDepartureLocation(flight.getDepartureLocation());
        flightDto.setDestinationLocation(flight.getDestinationLocation());
        flightDto.setName(flight.getName());
        flightDto.setFlightDescription(flight.getDepartureLocation().concat("-").concat(flight.getDestinationLocation()));
        return flightDto;
    }

    @Override
    public FlightDto getById(String id) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(id));
        if(optionalFlight.isPresent()) {
            Flight flight = new Flight();
            return FlightAdapter.toDto((flight));
        }
        throw new NoFlightException();
    }
}
