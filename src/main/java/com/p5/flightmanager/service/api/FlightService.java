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

    FlightDto createFlight(FlightDto flightDto);

    FlightDto getById(String id);

    FlightDto updateFlight(FlightDto flightDto);

    void deleteFlight(String id);

    void addPassengerToFlight(String flightId, String passengerId);

    Iterable<FlightDtoSimple> getByDepDateAndDestDateAndLocation(SearchParamDto searchParamDto);

    List<FlightDto> getBySearchParams(Date departureDate, String location, String destination);

    ListResponseDto<ResponseFlightDto> searchBy(FlightSearchDto searchDto);

    FlightDto addPassenger(FlightUpdateDto flightUpdateDto);

    Flight getFlightById(UUID flightId);
}