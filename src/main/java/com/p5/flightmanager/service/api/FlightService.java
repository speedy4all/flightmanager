package com.p5.flightmanager.Service.api;

import com.p5.flightmanager.Repository.Models.Flight;
import com.p5.flightmanager.Service.Dto.FlightDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightService {

    List<FlightDto> getAll();

    FlightDto createFlight();

    FlightDto getById(String id);
}
