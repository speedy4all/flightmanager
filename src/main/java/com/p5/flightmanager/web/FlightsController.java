package com.p5.flightmanager.web;

import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.service.FlightServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.transaction.annotation.Transactional;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping("/flights")
@Consumes("application/json")
@Produces("application/json")
@Transactional
public class FlightsController {

    @Autowired
    private FlightServiceImpl flightService;

    @GetMapping
    ResponseEntity<List<Flight>> getAll(){
        return ResponseEntity.ok(flightService.getAll());
    }

    @GetMapping("/{id}")
    ResponseEntity<Flight> getById(@PathVariable String id){
        return ResponseEntity.ok(flightService.getById(id));
    }

    @PostMapping
    ResponseEntity<Flight> createFlight(){
        return ResponseEntity.ok(flightService.createFlight());
    }
}
