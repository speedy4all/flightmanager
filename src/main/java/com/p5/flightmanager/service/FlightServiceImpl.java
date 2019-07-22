package com.p5.flightmanager.service;

import com.p5.flightmanager.repository.AirportRepository;
import com.p5.flightmanager.repository.PassengerRepository;
import com.p5.flightmanager.repository.PlaneRepository;
import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.FlightsRepository;
import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.repository.models.Plane;
import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.dto.FlightSearchDto;
import com.p5.flightmanager.service.dto.FlightUpdateDto;
import com.p5.flightmanager.service.dto.adapter.FlightAdapter;
import com.p5.flightmanager.service.dto.FlightDto;
import com.p5.flightmanager.service.dto.FlightSimpleDto;
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
    private AirportRepository airportRepository;

    @Autowired
    private PlaneRepository planeRepository;

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
        ApiError apiError = new ApiError(HttpStatus.BAD_REQUEST);

        if (flightDto.getDepartureAirport() == null) {
            apiError.getSubErrors().add(new ApiSubError("departureLocation", "Cannot be null"));
        }

        if (flightDto.getDestinationAirport() == null){
            apiError.getSubErrors().add(new ApiSubError("destinationLocation", "Cannot be null"));
        }

        if (flightDto.getDurationTime() > 180){
            apiError.getSubErrors().add(new ApiSubError("durationTime", "Value must be under 180",
                    String.valueOf(flightDto.getDurationTime())));
        }

        if (apiError.getSubErrors().size() > 0){
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
    public void setDepartureAndDestinationAirport(String flightId, String departureAirportIata, String destinationAirportIata) {
        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightId));
        if (optionalFlight.isPresent()){
            Optional<Airport> departureAirportOptional = airportRepository.findByIata(departureAirportIata);
            Optional<Airport> destinationAirportOptional = airportRepository.findByIata(destinationAirportIata);
            if (departureAirportOptional.isPresent() && destinationAirportOptional.isPresent()){
                Flight flight = optionalFlight.get();
                flight.setDepartureAirport(departureAirportOptional.get());
                flight.setDestinationAirport(destinationAirportOptional.get());
                flightsRepository.save(flight);
            }
        }
    }

    @Override
    public Iterable<FlightSimpleDto> getSimpleFlightDto() {
        return flightsRepository.findSimpleFlightDto();
    }

    @Override
    public List<FlightSimpleDto> searchBy(FlightSearchDto search) {
        Iterable<Flight> flights = flightsRepository.getByDepartureIdAndDestinationIdAndDepartureDate(UUID.fromString(search.getIdDeparture()),
                UUID.fromString(search.getIdDestination()), search.getDepartureDate());

        return FlightAdapter.toListSimpleDto(flights);
    }

    @Override
    public void addPassenger(FlightUpdateDto flightUpdateDto) {
        validateUpdateFlightDto(flightUpdateDto);

        Optional<Flight> optionalFlight = flightsRepository.findById(UUID.fromString(flightUpdateDto.getFlightId()));
        if (optionalFlight.isPresent()){
            Flight flight = optionalFlight.get();
            Passenger passenger = passengerRepository.getByIdentifyNumber(flightUpdateDto.getUniqueIdentifier());
            if (passenger == null){
                Passenger newPassenger = new Passenger();
                newPassenger.setFirstName(flightUpdateDto.getPassengerName());
                newPassenger.setIdentifyNumber(flightUpdateDto.getUniqueIdentifier());
                passenger = passengerRepository.save(newPassenger);
            }
            flight.getPassengerList().add(passenger);
            flightsRepository.save(flight);
        }
    }

    private void validateUpdateFlightDto(FlightUpdateDto flightUpdateDto){
        //todo implement validation
    }

}
