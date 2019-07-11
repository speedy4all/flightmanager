package com.p5.flightmanager.Service.api;

import com.p5.flightmanager.Repository.Models.Flight;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface FlightService {

    List<Flight> getAll();

    Flight createFlight();

    Flight getById(String id);
}
