package com.p5.flightmanager.service.api;

import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.service.dto.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public interface FlightService {

    List<FlightDto> getAll(String search);

    FlightDto createFlight(PostFlightDto postFlightDto);

    FlightDto getById(String id);

    FlightDto updateFlight(FlightDto flightDto);

    void deleteFlight(String flightDtoID);

    void addPassenger(FlightUpdateDto flightDto);

    void addPassengerToFlight(String flightId, String passengerId);

    void addPlaneToFlight(String flightId, String planeId);

    void addDestinationAirport(String flightId, String destinationAirportId);

    void addLocationAirport(String flightId, String locationAirportId);

    List<FlightDto> getBySearchParams(Date departureDate, String location);

    Iterable<FlightDto> getByDepDateAndDestDateAndLocation(SearchParamFlightDto searchParamDto);

    Iterable<FlightDtoView> getByLocationIdAndDestinationIdAirportAndDate(SearchParamsFlightDtoView searchParamDto);

    Iterable<FlightDtoSimple> getAllFlights();

    Flight getFlightById(UUID id);

    List<FlightDtoSimple> getOffers();

    List<FlightDtoView> searchBy(SearchParamsFlightDtoView search);

    void deletePassenger(String flightId, String personalId);

    List<FlightDtoSimple> getAllMyFlights(String id);
}
