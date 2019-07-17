package com.p5.flightmanager.service;

import com.p5.flightmanager.service.dto.adapter.PassengersRepository;
import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.FlightsRepository;
import com.p5.flightmanager.repository.models.Passenger;
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

@Component
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightsRepository flightsRepository;

    @Autowired
    private PassengersRepository passengersRepository;

    public List<FlightDto> getAll(String search) {

        return FlightAdapter.toListDto(flightsRepository.filterByName(search));
    }

    @Override
    public FlightDto createFlight(FlightDto flightDto) {

        Flight flight = null;
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
        if(flightDto.getDepartureLocation()== null || flightDto.getDepartureLocation().isEmpty()) {
            return false;
        }
        if(flightDto.getDestinationLocation() == null || flightDto.getDestinationLocation().isEmpty()) {
            return false;
        }
        return true;
    }
    @Override
    public void addPassengerToFlight(String flightId, String passengerId){
        Optional<Flight> optionalFlight=flightsRepository.findById((UUID.fromString(flightId)));
        if (optionalFlight.isPresent()){
            Optional<Passenger> optionalPassenger=passengersRepository.findById((UUID.fromString(passengerId)));
            if(optionalPassenger.isPresent()){
                Flight flight=optionalFlight.get();
                flight.getPassengerList().add(optionalPassenger.get());
                flightsRepository.save(flight);

            }
        }
    }
}
