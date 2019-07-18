package com.p5.flightmanager.service.api;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AirportService {

    List<AirportDto> getAll(String search);

    AirportDto createAirport(AirportDto airportDto);

    AirportDto getById(String id);

    AirportDto updateAirport(AirportDto airportDto);

    Optional<Airport> getByName(String name);

    void deleteAirport(String id);

    void addFlight(String airportId, String flightId);
}
