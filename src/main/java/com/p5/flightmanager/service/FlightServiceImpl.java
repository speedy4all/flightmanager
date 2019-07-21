package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.AirportRepository;
import com.p5.flightmanager.repository.PassengerRepository;
import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.FlightsRepository;
import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.service.api.AirportService;
import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.dto.*;
import com.p5.flightmanager.service.exceptions.ApiError;
import com.p5.flightmanager.service.exceptions.ApiSubError;
import com.p5.flightmanager.service.exceptions.NoFlightException;
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
    private AirportRepository airportRepository;

    @Autowired
    private PassengerRepository passengerRepository;

    @Autowired
    private AirportService airportService;

    //    @Override
//    public List<FlightDto> getAll(String search) {
//
//        return FlightAdapter.toListDto(flightsRepository.filterByName(search));
//    }
    @Override
    public List<FlightDtoView> getAll(String search) {

        return FlightAdapter.toListDtoView(flightsRepository.filterByName(search));
    }

    @Override
    public FlightDto createFlight(FlightDto flightDto) {


        validateFlightDto(flightDto);

        Flight flight = FlightAdapter.fromDto(flightDto);

        Optional<Airport> departureOptionalAirport = airportRepository.findById(UUID.fromString(flightDto.getDepartureLocation()));
        Optional<Airport> destinationOptionalAirport = airportRepository.findById(UUID.fromString(flightDto.getDestinationLocation()));

        if (departureOptionalAirport.isPresent() && destinationOptionalAirport.isPresent()) {
            flight.setDepartureLocation(departureOptionalAirport.get());
            flight.setDestinationLocation(destinationOptionalAirport.get());
        }

        return FlightAdapter.toDto(flightsRepository.save(flight));

    }

    private void validateFlightDto(FlightDto flightDto) {
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);

        if (flightDto.getDestinationLocation() == null) {
            apiError.getSubErrors().add(new ApiSubError("destinationLocation", "Null received"));
        }
        if (flightDto.getFlightType() == null) {
            apiError.getSubErrors().add(new ApiSubError("flightType", "Null received", String.valueOf(flightDto.getFlightType())));
        }
        if (flightDto.getDurationTime() > 60) {
            apiError.getSubErrors().add(new ApiSubError("flightType", String.valueOf(flightDto.getDurationTime()), "Should be less then 60"));
        }


        if (apiError.getSubErrors().size() > 0) {
            throw new NoFlightException(apiError);
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
            if(optionalFlight.get().getPassengerList().size() <= optionalFlight.get().getPlane().getSeats()){
                if (optionalPassenger.isPresent()) {
                    Flight flight = optionalFlight.get();
                    flight.getPassengerList().add(optionalPassenger.get());
                    flightsRepository.save(flight);
                }
            }
        }
    }

    @Override
    public Iterable<FlightDtoSearch> getByDepDateAndDestDateAndLocation(SearchParamDto searchParamDto) {
        return flightsRepository.findByNameAndDAteSimple(searchParamDto.getDepartureDate(), searchParamDto.getLocation());
    }
}
