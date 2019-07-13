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
        //Flight newFlight = new Flight("First flight", "BUH", "CN", 8d, new Date(), new Date());
        if(!isValidateFlight(flightDto)) {
            throw  new EmptyFieldException();
        }
        Flight flight = flightsRepository.save(FlightAdapter.fromDto(flightDto));

        return FlightAdapter.toDto(flight);
    }

    private boolean isValidateFlight(FlightDto flightDto) {
        if (flightDto.getDepartureLocation() == null || flightDto.getDepartureLocation().isEmpty()) {
            return false;
        }
        if (flightDto.getDestinationLocation() == null || flightDto.getDestinationLocation().isEmpty()){
            return false;
        }
        if (flightDto.getName() == null || flightDto.getName().isEmpty()){
            return false;
        }
        if(flightDto.getDurationTime() == null || flightDto.getDurationTime().isNaN()) {
            return false;
        }
        if(flightDto.getDepartureDate() == null || flightDto.getDestinationDate() == null) {
            return false;
        }
        return true;
    }
        @Override
        public FlightDto getById(String id) {
            Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(id));
            if(optionalFlight.isPresent()) {
                Flight flight = optionalFlight.get();
                return FlightAdapter.toDto(flight);
            }
            //throw new NoFlightException("No flight found");
            throw new NoFlightException();
        }

    @Override
    public FlightDto updateFlight(FlightDto flightDto) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightDto.getId()));
        if(optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            FlightAdapter.fromDto(flightDto, flight);
            flightsRepository.save(flight);
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
            return;
        }
        throw new NoFlightException();
    }


}
