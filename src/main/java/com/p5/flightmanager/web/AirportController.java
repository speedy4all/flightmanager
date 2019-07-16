package com.p5.flightmanager.web;

import com.p5.flightmanager.service.api.AirportService;
import com.p5.flightmanager.service.dto.AirportDto;
import net.bytebuddy.asm.Advice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping("/airport")
@Consumes("application/json")
@Produces("application/json")
@Transactional
public class AirportController {

    @Autowired
    private AirportService airportService;

    @GetMapping
    ResponseEntity<List<AirportDto>> getAll(@RequestParam String search) {

        return ResponseEntity.ok(airportService.getAll(search));
    }

    @GetMapping("/{id}")
    ResponseEntity<AirportDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(airportService.getById(id));
    }

    @PostMapping
    ResponseEntity<AirportDto> createAirport(@RequestBody AirportDto airportDto) {
        return ResponseEntity.ok(airportService.createAirport(airportDto));
    }

    @PutMapping("/update")
    ResponseEntity<AirportDto> updateAirport(@RequestBody AirportDto airportDto) {
        return ResponseEntity.ok(airportService.updateAirport(airportDto));
    }

    @DeleteMapping("/{id}")
    void deleteFlight(@PathVariable String id) {
        airportService.deleteAirport(id);
    }
}
