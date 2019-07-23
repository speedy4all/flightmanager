package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.PassengerRepository;
import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.FlightsRepository;
import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.service.api.AirportService;
import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.dto.*;
import com.p5.flightmanager.service.exceptions.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

    @Override
    public List<FlightDto> getAll(String search) {

        return FlightAdapter.toListDto(flightsRepository.filterByName(search));
    }

    @Override
    public FlightDto createFlight(FlightDto flightDto) {
        validateFlightDto(flightDto);

        return FlightAdapter.toDto(flightsRepository.save(FlightAdapter.fromDto(flightDto)));



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

    private void validateFlightDto(FlightDto flightDto) {

        ApiError apiError=new ApiError(HttpStatus.BAD_REQUEST);
        if (flightDto.getDepartureLocation() == null){
    apiError.getSubErrors().add(new ApiSubError("departureLocation","Can not be null"));}
        if (flightDto.getDestinationLocation() == null || flightDto.getDestinationLocation().isEmpty()){
            apiError.getSubErrors().add(new ApiSubError("departureLocation","Can not be null"));
        }

        if(flightDto.getDurationTime()>180){
            apiError.getSubErrors().add((new ApiSubError("durationTime","Value must be under 180",String.valueOf(flightDto.getDurationTime()))));
        }
        if(apiError.getSubErrors().size()>0){
            throw new FlightValidationException(apiError);
        }
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
    public Iterable<FlightDtoSimple> getByDepDateAndDestDateAndLocation(SearchParamDto searchParamDto) {
        return flightsRepository.findByNameAndDAteSimple(searchParamDto.getDepartureDate(), searchParamDto.getLocation());
    }


}
