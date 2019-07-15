package com.p5.flightmanager.web;


import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.dto.FlightDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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
    private FlightService flightService;

    @GetMapping
    ResponseEntity<List<FlightDto>> getAll(@RequestParam String search) {
        return ResponseEntity.ok(flightService.getAll(search));
    }

    @GetMapping("/{id}")
    ResponseEntity<FlightDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(flightService.getById(id));
    }

    @PostMapping
    ResponseEntity<FlightDto> createFlight(@RequestBody FlightDto flightDto) {
        return ResponseEntity.ok(flightService.createFlight(flightDto));
    }

    @PutMapping("/update")
    ResponseEntity<FlightDto> updateFlight(@RequestBody FlightDto flightDto){
        return ResponseEntity.ok(flightService.updateFlight(flightDto));
    }

    @DeleteMapping("/{id}")
    void deleteFlight(@PathVariable String id){
        flightService.deleteFlight(id);
    }
}
