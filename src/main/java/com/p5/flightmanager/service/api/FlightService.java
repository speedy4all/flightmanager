package com.p5.flightmanager.service.api;

import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.FlightsRepository;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface FlightService {


    List<Flight> getAll();

    Flight createFlight();

    Flight getById(String id);

}
