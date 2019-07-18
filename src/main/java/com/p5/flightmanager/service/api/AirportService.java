package com.p5.flightmanager.service.api;

import org.jvnet.hk2.annotations.Service;

@Service

public interface AirportService {
    List<AirportDto>getAll(String search);
    AirportDo createAirport(AirportDto airportDto);
    AirportDto getById(String id);
    AirportDto updateAirport(AirportDto airportDto);
    void deteleAirport(String id);
    void addDFlightToAirport(String airportId, String flight);
}
