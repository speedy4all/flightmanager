package com.p5.flightmanager.service.api;

import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.service.dto.AirportDto;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AirportService {

    List<AirportDto> getAll(String search);
    AirportDto getById(String id);
    AirportDto updateAirport(AirportDto airportDto);
    AirportDto createAirport(AirportDto airportDto);
    void delete(String id);
}
