package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.AirportsRepository;
import com.p5.flightmanager.repository.PassengersRepository;
import com.p5.flightmanager.repository.PlanesRepository;
import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.FlightsRepository;
import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.repository.models.Plane;
import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.dto.FlightAdapter;
import com.p5.flightmanager.service.dto.FlightDto;
import com.p5.flightmanager.service.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@Component
public class FlightServiceImpl implements FlightService {

    @Autowired
    private FlightsRepository flightsRepository;

    @Autowired
    private PassengersRepository passengerRepository;

    @Autowired
    private PlanesRepository planeRepository;

    @Autowired
    private AirportsRepository airportsRepository;

    public List<FlightDto> getAll(String search) {

        return FlightAdapter.toListDto(flightsRepository.filterByName(search));
    }

    @Override
    public FlightDto createFlight(FlightDto flightDto) {

        if(!isValidFlight(flightDto))
        {
            throw new EmptyFieldException();
        }

        return FlightAdapter.toDto(flightsRepository.save(FlightAdapter.fromDto(flightDto)));
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
    public FlightDto updateFlight(FlightDto flightDto) {

         Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightDto.getId()));
         if(optionalFlight.isPresent()){
             return FlightAdapter.toDto( flightsRepository.save(FlightAdapter.fromDto(flightDto,optionalFlight.get())));
         }

        throw new NoFlightException();
    }

    @Override
    public void deleteFlight(String flightDtoID) {

        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightDtoID));
        if(optionalFlight.isPresent()){
            flightsRepository.delete(optionalFlight.get());
            return;
        }

        throw new NoFlightException();
    }

    @Override
    public void addPassengerToFlight(String flightId, String passengerId) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightId));
        if(optionalFlight.isPresent()) {
            Optional<Passenger> optionalPassenger = passengerRepository.findById(UUID.fromString(passengerId));
            if(optionalPassenger.isPresent()) {
                Flight flight = optionalFlight.get();
                optionalFlight.get().getPassengerList().add(optionalPassenger.get());
                flightsRepository.save(flight);
            }
        }
    }

    @Override
    public void addPlaneToFlight(String flightId, String planeId) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightId));
        if(optionalFlight.isPresent()) {
            Optional<Plane> optionalPlane = planeRepository.findById(UUID.fromString(planeId));
            if(optionalPlane.isPresent()) {
                Flight flight = optionalFlight.get();
                Plane plane = optionalPlane.get();
                flight.setPlane(plane);
                flightsRepository.save(flight);
            }
        }
    }

    @Override
    public void addDestinationAirport(String flightId, String destinationAirportId) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightId));
        if(optionalFlight.isPresent()) {
            Optional<Airport> optionalAirport = airportsRepository.findById(UUID.fromString(destinationAirportId));
            if(optionalAirport.isPresent()) {
                Flight flight = optionalFlight.get();
                Airport airport = optionalAirport.get();
                flight.setDestinationAirport(airport);
                flightsRepository.save(flight);
            }
        }
    }

    @Override
    public void addLocationAirport(String flightId, String locationnAirportId) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightId));
        if(optionalFlight.isPresent()) {
            Optional<Airport> optionalAirport = airportsRepository.findById(UUID.fromString(locationnAirportId));
            if(optionalAirport.isPresent()) {
                Flight flight = optionalFlight.get();
                Airport airport = optionalAirport.get();
                flight.setLocationAirport(airport);
                flightsRepository.save(flight);
            }
        }
    }

    private boolean isValidFlight(FlightDto flightDto) {
        if(StringUtils.isEmpty(flightDto.getDepartureLocation())) {
            return false;
        }

        if(flightDto.getDestinationLocation() == null || flightDto.getDestinationLocation().isEmpty()) {
            return false;
        }
        //TODO api error
        return true;
    }

}
