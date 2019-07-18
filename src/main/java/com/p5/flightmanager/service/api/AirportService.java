package com.p5.flightmanager.service.api;

import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.service.dto.AirportDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public interface AirportService {

    List<String> getAll(String search);

    String createAirport(AirportDto airportDto);

    String getById(String id);

    String updateAirport(AirportDto airportDto);

    Optional<Airport> getByName(String name);

    void deleteAirport(String id);

    void addFlight(String airportId, String flightId);
}
