package com.p5.flightmanager.service.api;

import com.p5.flightmanager.service.dto.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface FlightService {

    List<FlightDto> getAll(String search);

    FlightDto createFlight(PostFlightDto postFlightDto);

    FlightDto getById(String id);

    FlightDto updateFlight(FlightDto flightDto);

    void deleteFlight(String flightDtoID);

    void addPassengerToFlight(String flightId, String passengerId);

    void addPlaneToFlight(String flightId, String planeId);

    void addDestinationAirport(String flightId, String destinationAirportId);

    void addLocationAirport(String flightId, String locationAirportId);

    List<FlightDto> getBySearchParams(Date departureDate, String location);

    Iterable<FlightDto> getByDepDateAndDestDateAndLocation(SearchParamFlightDto searchParamDto);

    Iterable<FlightDtoView> getByLocationIdAndDestinationIdAirport(SearchParamsFlightDtoView searchParamDto);

    Iterable<FlightDtoSimple> getAllFlights();
}
