package com.p5.flightmanager.service.api;

import com.p5.flightmanager.service.dto.*;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public interface FlightService {

    //List<FlightDto> getAll(String search);
    List<FlightDtoView> getAll(String search);

    FlightDto createFlight(FlightDto flightDto);

    FlightDto getById(String id);

    FlightDto updateFlight(FlightDto flightDto);

    void deleteFlight(String id);

    void addPassengerToFlight(String flightId, String passengerId);

    Iterable<FlightDtoSimple> getByDepDateAndDestDateAndLocation(SearchParamDto searchParamDto);

    List<FlightDto> getBySearchParams(Date departureDate, String location, String destination);

   // Iterable<FlightDtoParamSearch> getByDepIdAndDestIdAndDepDate(SearchParamDtoFlight searchParamDtoFlight);
}
