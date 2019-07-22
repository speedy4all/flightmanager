package com.p5.flightmanager.service.api;

import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.service.dto.AirportDto;
import com.p5.flightmanager.service.dto.AirportSimpleDTO;
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

    Iterable<AirportSimpleDTO> getAllForSelect();
}
