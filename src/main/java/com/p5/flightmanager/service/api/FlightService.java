package com.p5.flightmanager.service.api;

import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.service.dto.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public interface FlightService {

    ListResponseDto<ResponseFlightDto> getAll(String search);

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

    Iterable<FlightDtoSimple> getByDepDateAndDestDateAndLocation(SearchParamFlightDto searchParamDto);

    ListResponseDto<ResponseFlightDto> getAllFlights();

    Flight getFlightById(UUID id);

    ListResponseDto<ResponseFlightDto> getOffers();

    ListResponseDto<ResponseFlightDto> searchBy(SearchParamsFlight search);

    void deletePassenger(String flightId, String personalId);

    ListResponseDto<ResponseFlightDto> getAllMyFlights(String id);

    ListResponseDto<ResponseFlightDto> getAllByName(String name);
}
