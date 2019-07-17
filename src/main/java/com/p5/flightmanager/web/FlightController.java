package com.p5.flightmanager.web;

import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.dto.FlightDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping("/flights")
@Consumes("application/json")
@Produces("application/json")
@Transactional //im momentul in care s-a mappat metodele din clasa vor primi o tranzactie noua de fiecare data cand o metoda este apelata
//la fiecare metoda se dechide cate o tranzactie
public class FlightController {

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

    @PutMapping
    ResponseEntity<FlightDto> updateFlight(@RequestBody FlightDto flightDto) {

        return ResponseEntity.ok(flightService.updateFlight(flightDto));
    }

    @DeleteMapping("/{iddelete}")
    void deleteFlight(@PathVariable String iddelete) {

        flightService.deleteFlight(iddelete);
    }

    @PutMapping("/{flightId}/add-passenger/{passengerId}")
    void addPassengerToFlight(@PathVariable String flightId, @PathVariable String passengerId) {
        flightService.addPassengerToFlight(flightId,passengerId);
    }
}
