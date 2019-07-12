package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.FlightsRepository;
import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.dto.FlightAdapter;
import com.p5.flightmanager.service.dto.FlightDto;
import com.p5.flightmanager.service.exceptions.EmptyFieldException;
import com.p5.flightmanager.service.exceptions.NoFlightException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public FlightDto createFlight(FlightDto flightDto) {

        if(!isValidFlight(flightDto))
        {
            throw new EmptyFieldException();
        }
        Flight flight = flightsRepository.save(FlightAdapter.fromDto(flightDto));

        return FlightAdapter.toDto(flight);
    }

    @Override
    public FlightDto getById(String id) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(id));
        if(optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            return FlightAdapter.toDto(flight);
        }
        throw new NoFlightException();
    }

    private boolean isValidFlight(FlightDto flightDto) {
        if(flightDto.getDepartureLocation() == null) {
            return false;
        }
        if(flightDto.getDepartureLocation().isEmpty()) {
            return false;
        }
        if(flightDto.getDestinationLocation() == null) {
            return false;
        }
        if(flightDto.getDestinationLocation().isEmpty()) {
            return false;
        }
        return true;
    }

    //eu
    @Override
    public FlightDto deleteFlight(String id)
    {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(id));
        if(optionalFlight.isPresent())
        {
            Flight flight = optionalFlight.get();
            FlightDto flightDto = new FlightDto();
            flightDto = FlightAdapter.toDto(flight);
            flightsRepository.delete(FlightAdapter.fromDto(flightDto));
        }
        return null;
    }
}
