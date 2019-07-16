package com.p5.flightmanager.service.api;

import com.p5.flightmanager.service.dto.AirportDto;
import com.p5.flightmanager.service.dto.PassengerDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AirportService {
    List<AirportDto> getAll(String search);

    AirportDto createAirport(AirportDto airportDto);

    AirportDto getById(String id);

    AirportDto updateAirport(AirportDto airportDto);

    void deleteAirport(String airportDtoId);
}

