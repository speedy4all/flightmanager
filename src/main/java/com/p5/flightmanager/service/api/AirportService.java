package com.p5.flightmanager.service.api;

import com.p5.flightmanager.service.dto.AirportDto;
import com.p5.flightmanager.service.dto.AirportDtoView;
import com.p5.flightmanager.service.dto.SearchParamAirportDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface AirportService {

    List<AirportDto> getAll(String search);

    AirportDto getById(String id);

    AirportDto updateAirport(AirportDto airportDto);

    AirportDto createAirport(AirportDto airportDto);

    void delete(String id);

    void addFlight(String airportId, String flightId);

    List<AirportDtoView> getAllDtos();
}
