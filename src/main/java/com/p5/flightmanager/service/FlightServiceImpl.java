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
import com.p5.flightmanager.service.dto.*;
import com.p5.flightmanager.service.exceptions.*;
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
    private PassengersRepository passengerRepository;

    @Autowired
    private PlanesRepository planeRepository;

    @Autowired
    private AirportsRepository airportsRepository;

    public List<FlightDto> getAll(String search) {

        return FlightAdapter.toListDto(flightsRepository.filterByName(search));
    }

    @Override
    public FlightDto createFlight(PostFlightDto postFlightDto) {

        Optional<Plane> optionalPlane = planeRepository.findById(UUID.fromString(postFlightDto.getPlaneId()));
        if(!optionalPlane.isPresent()) {
           throw new NoAirportException(); //TODO NoPlaneException
        }
        Optional<Airport> optionalLocation = airportsRepository.findById(UUID.fromString(postFlightDto.getLocationAirportId()));
        if(!optionalLocation.isPresent()) {
            throw  new NoAirportException();
        }
        Optional<Airport> optionalDestination = airportsRepository.findById(UUID.fromString(postFlightDto.getDestinationAirportId()));
        if(!optionalDestination.isPresent()) {
            throw new NoAirportException();
        }
        return FlightAdapter.toDto(flightsRepository.save(FlightAdapter.fromPostDto(postFlightDto, optionalPlane.get(), optionalLocation.get(), optionalDestination.get())));
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

    @Override
    public List<FlightDto> getBySearchParams(Date departureDate, String location) {
        Iterable<Flight> flights = flightsRepository.getBySearchparams(departureDate, location);
        return FlightAdapter.toListDto(flights);
    }

    @Override
    public Iterable<FlightDto> getByDepDateAndDestDateAndLocation(SearchParamFlightDto searchParamDto) {
        return flightsRepository.findByNameAndDAte(searchParamDto.getDepartureDate(), searchParamDto.getLocation());
    }

    @Override
    public Iterable<FlightDtoView> getByLocationIdAndDestinationIdAirport(SearchParamsFlightDtoView searchParamDto) {
        return flightsRepository.findByLocationIdAndDestinationIdAirport(UUID.fromString(searchParamDto.getLocationAirportId())
                , UUID.fromString(searchParamDto.getDestinationAirportId()));
    }

    private boolean isValidFlight(FlightDto flightDto) {
//        if(StringUtils.isEmpty(flightDto.getDestinationAirport().getCode())) {
//            return false;
//        }

//        if(flightDto.getDestinationLocation() == null || flightDto.getDestinationLocation().isEmpty()) {
//            return false;
//        }
        //TODO api error
        return true;
    }



}
