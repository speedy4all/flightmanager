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

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightsRepository flightsRepository;

    @Override
    public List<FlightDto> getAll(String search) {

        return FlightAdapter.toListDto(flightsRepository.filterByName(search));
    }

    @Override
    public FlightDto createFlight(FlightDto flightDto) {

        Flight flight = null;
        //Flight newFlight = new Flight("First flight", "BUH", "CN", 8d, new Date(), new Date());
        if(isValidFlight(flightDto)) {

             flight = flightsRepository.save(FlightAdapter.fromDto(flightDto));
        } else {
            throw new EmptyFieldException();

        }
        return FlightAdapter.toDto(flight);
    }

    @Override
    public FlightDto updateFlight(FlightDto flightDto) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightDto.getId()));
        if(optionalFlight.isPresent()) {

            Flight flight = optionalFlight.get();
            flight = FlightAdapter.fromDto(flightDto, flight);
            flightsRepository.save(flight);
            return FlightAdapter.toDto(flight);
        }
        throw new NoFlightException();
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

    @Override
    public void deleteFlight(String id) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(id));
        if(optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            flightsRepository.delete(flight);
        }
    }

    private  boolean isValidFlight(FlightDto flightDto) {
        if(flightDto.getDepartureLocation()== null || flightDto.getDepartureLocation().isEmpty())
            return false;
        if(flightDto.getDestinationLocation() == null || flightDto.getDestinationLocation().isEmpty())
            return false;
        return true;
    }
}
