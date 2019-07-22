package com.p5.flightmanager.web;

import com.p5.flightmanager.service.api.AirportService;
import com.p5.flightmanager.service.dto.AirportDto;
import com.p5.flightmanager.service.dto.AirportSimpleDto;
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
    ResponseEntity<List<AirportDto>> getAll(@RequestParam String search){
        return ResponseEntity.ok(airportService.getAll(search));
    }

    @GetMapping("/{id}")
    ResponseEntity<AirportDto> getById(@PathVariable String id){
        return ResponseEntity.ok(airportService.getById(id));
    }

    @GetMapping("/iata/{iata}")
    ResponseEntity<AirportDto> getByIata(@PathVariable String iata){
        return ResponseEntity.ok(airportService.getByIata(iata));
    }

    //TODO: endpoint care returneaza o lista de dto-uri care contine din aeroport numele, id-ul(iata), city; DONE
    @GetMapping("/simple-list")
    ResponseEntity<Iterable<AirportSimpleDto>> getAllSimpleAirports(){
        return ResponseEntity.ok(airportService.getAllSimpleAirports());
    }

    @PostMapping
    ResponseEntity<AirportDto> createAirport(@RequestBody AirportDto airportDto){
        return ResponseEntity.ok(airportService.createAirport(airportDto));
    }

    @PutMapping()
    ResponseEntity<AirportDto> updateAirport(@RequestBody AirportDto airportDto) {
        return ResponseEntity.ok(airportService.updateAirport(airportDto));
    }

    @PutMapping("/{airportId}/add-flight/{flightId}")
    void addFlightToAirport(@PathVariable String airportId, @PathVariable String flightId) {
        airportService.addFlightToAirport(airportId, flightId);
    }

    @DeleteMapping("/{id}")
    void deleteAirport(@PathVariable String id) {
        airportService.deleteAirport(id);
    }
}
