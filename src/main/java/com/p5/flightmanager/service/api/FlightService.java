package com.p5.flightmanager.service.api;

import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.service.dto.FlightDto;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
public interface FlightService {

    public List<Flight> getAll();

    FlightDto createFlight();

    Flight getById(String id);
}
