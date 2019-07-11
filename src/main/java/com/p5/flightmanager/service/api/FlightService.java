package com.p5.flightmanager.service.api;

import com.p5.flightmanager.repository.models.Flight;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightService {

    List<Flight> getAll();

    Flight createFlight();

    Flight getById(String id);
}
