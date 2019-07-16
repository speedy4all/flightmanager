package com.p5.flightmanager.web;


import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.api.PassengerService;
import com.p5.flightmanager.service.dto.PassengerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping("/passengers")
@Consumes("application/json")
@Produces("application/json")
@Transactional
public class PassengersController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    ResponseEntity<List<PassengerDto>> getAll(@RequestParam String search) {

        return ResponseEntity.ok(passengerService.getAll(search));
    }

    @GetMapping("/{id}")
    ResponseEntity<PassengerDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(passengerService.getById(id));
    }

    @PostMapping
    ResponseEntity<PassengerDto> createPassenger(@RequestBody PassengerDto passengerDto) {
        return ResponseEntity.ok(passengerService.createPassenger(passengerDto));
    }

    @PutMapping("/update")
    ResponseEntity<PassengerDto> updatePassenger(@RequestBody PassengerDto passengerDto) {
        return ResponseEntity.ok(passengerService.updatePassenger(passengerDto));
        //return ResponseEntity.ok("Update flight");
    }

    @DeleteMapping("/{id}")
    void deletePassenger(@PathVariable String id) {
        passengerService.deletePassenger(id);
    }
}
