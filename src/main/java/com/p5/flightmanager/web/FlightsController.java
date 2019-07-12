package com.p5.flightmanager.web;

import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.dto.FlightDto;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping("/flights")
@Consumes("application/jason")
@Produces("application/json")
@Transactional
public class FlightsController {

private FlightService flightService;

    @GetMapping
    ResponseEntity<List<Flight>> getAll() {
        return ResponseEntity.ok(flightService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Flight> getById(@PathVariable String id) {
        return ResponseEntity.ok(flightService.getById(id));
    }

    @PostMapping
    ResponseEntity<FlightDto> createFlight() {
        return ResponseEntity.ok(flightService.createFlight());
    }
}

    //List<Flight> flights = new ArrayList<>();
        //flightsRepository.findAll().forEach(flights::add);
                //return ResponseEntity.ok(flights)
//flightsRepository.findAll().forEach(this::addToList);