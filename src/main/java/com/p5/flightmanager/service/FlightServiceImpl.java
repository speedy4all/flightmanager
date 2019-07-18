package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.PassengerRepository;
import com.p5.flightmanager.repository.PlaneRepository;
import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.FlightsRepository;
import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.repository.models.Plane;
import com.p5.flightmanager.service.api.AirportService;
import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.dto.adapter.FlightAdapter;
import com.p5.flightmanager.service.dto.FlightDto;
import com.p5.flightmanager.service.dto.FlightDtoSimple;
import com.p5.flightmanager.service.dto.SearchParamDto;
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

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private AirportService airportService;

    @Autowired
    private PlaneRepository planeRepository;

    @Override
    public List<FlightDto> getAll(String search) {

        return FlightAdapter.toListDto(flightsRepository.filterByName(search));
    }

    @Override
    public FlightDto createFlight(FlightDto flightDto) {

        if (isValidFlight(flightDto)) {

            return FlightAdapter.toDto(flightsRepository.save(FlightAdapter.fromDto(flightDto)));
        } else {
            throw new EmptyFieldException();

        }
    }

    @Override
    public FlightDto updateFlight(FlightDto flightDto) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightDto.getId()));
        if (optionalFlight.isPresent()) {

            return FlightAdapter.toDto(flightsRepository.save(FlightAdapter.fromDto(flightDto, optionalFlight.get())));
        }
        throw new NoFlightException();
    }

    @Override
    public FlightDto getById(String id) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(id));
        if (optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            return FlightAdapter.toDto(flight);
        }
        throw new NoFlightException();
    }

    @Override
    public void deleteFlight(String id) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(id));
        if (optionalFlight.isPresent()) {
            Flight flight = optionalFlight.get();
            flightsRepository.delete(flight);
        }
    }

    private boolean isValidFlight(FlightDto flightDto) {
        if (flightDto.getDepartureLocation() == null)
            return false;
        if (flightDto.getDestinationLocation() == null || flightDto.getDestinationLocation().isEmpty())
            return false;
        return true;
    }

    @Override
    public List<FlightDto> getBySearchParams(Date departureDate, String location, String destination) {
        Iterable<Flight> flights = flightsRepository.getBySearchParams(departureDate, location, destination);
        return FlightAdapter.toListDto(flights);
    }

    @Override
    public void addPassengerToFlight(String flightId, String passengerId) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightId));
        if (optionalFlight.isPresent()) {
            Optional<Passenger> optionalPassenger = passengerRepository.findById(UUID.fromString(passengerId));
            if (optionalPassenger.isPresent()) {
                Flight flight = optionalFlight.get();
                flight.getPassengerList().add(optionalPassenger.get());
                flightsRepository.save(flight);
            }
        }
    }

    @Override
    public void associatePlaneToFlight(String flightId, String planeId) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightId));
        if (optionalFlight.isPresent()) {
            Optional<Plane> optionalPlane = planeRepository.findById(UUID.fromString(planeId));
            if (optionalPlane.isPresent()) {
                Flight flight = optionalFlight.get();
                flight.setPlane(optionalPlane.get());
                flightsRepository.save(flight);
            }
        }
    }

    @Override
    public Iterable<FlightDtoSimple> getByDepDateAndDestDateAndLocation(SearchParamDto searchParamDto) {
        return flightsRepository.findByNameAndDAteSimple(searchParamDto.getDepartureDate(), searchParamDto.getLocation());
    }
}
