package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.FlightsRepository;
import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.dto.FlightAdapter;
import com.p5.flightmanager.service.dto.FlightDto;
import com.p5.flightmanager.service.exceptions.EmptyFieldException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Component
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightsRepository flightsRepository;

    // private FlightAdapter flightAdapter = new FlightAdapter();

    public List<FlightDto> getAll() {
        return FlightAdapter.toListDto(flightsRepository.findAll());
    }

    @Override
    public FlightDto createFlight(FlightDto flightDto) {
        //Flight newFlight = new Flight("First flight", "BUH", "CN", 8d, new Date(), new Date());
        if(isValidFlight(flightDto)) {
            Flight flight = flightsRepository.save(FlightAdapter.fromDto(flightDto));
            return FlightAdapter.toDto(flight);
        }
        else
            throw new EmptyFieldException();
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

    public boolean isValidFlight(FlightDto flightDto) {

        if(flightDto.getDestinationLocation() == null || flightDto.getDepartureLocation().isEmpty())
            return false;
        return true;
    }

    @Override
    public FlightDto updateFlight(FlightDto flightDto) {
        if (isValidFlight(flightDto)) {
            Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightDto.getId()));
            if (optionalFlight.isPresent()) {
                Flight flight = flightsRepository.save(FlightAdapter.fromDto(flightDto, optionalFlight.get()));
                return FlightAdapter.toDto(flight);
            }
        }
        throw new EmptyFieldException();
    }

    @Override
    public boolean deleteFlight(String id) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(id));
        if(optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            flightsRepository.delete(flight);
            return true;
        }
        else {
            throw new NoFlightException();
        }
    }

}