package com.p5.flightmanager.service.api;

import com.p5.flightmanager.service.dto.FlightDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightService {

    List<FlightDto> getAll(String search);

    FlightDto createFlight(FlightDto flightDto);

    FlightDto getById(String id);

    FlightDto updateFlight(FlightDto flightDto);

    void deleteFlight(String flightDtoID);

    void addPassengerToFlight(String flightId, String passengerId);
}
