package com.p5.flightmanager.service.api;

import com.p5.flightmanager.service.dto.FlightDto;
import com.p5.flightmanager.service.dto.FlightDtoSimple;
import com.p5.flightmanager.service.dto.SearchParamDto;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface FlightService {

    List<FlightDto> getAll(String search);

    FlightDto createFlight(FlightDto flightDto);

    FlightDto getById(String id);

    FlightDto updateFlight(FlightDto flightDto);

    void deleteFlight(String id);

    void addPassengerToFlight(String flightId, String passengerId);

    void associatePlaneToFlight(String flightId, String planeId);

    Iterable<FlightDtoSimple> getByDepDateAndDestDateAndLocation(SearchParamDto searchParamDto);

    List<FlightDto> getBySearchParams(Date departureDate, String location, String destination);
}
