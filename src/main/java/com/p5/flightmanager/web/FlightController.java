package com.p5.flightmanager.web;

import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.dto.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/flights")
@Consumes("application/json")
@Produces("application/json")
@Transactional //im momentul in care s-a mapat metodele din clasa vor primi o tranzactie noua de fiecare data cand o metoda este apelata
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
    ResponseEntity<FlightDto> createFlight(@RequestBody PostFlightDto postFlightDto) {
        return ResponseEntity.ok(flightService.createFlight(postFlightDto));
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

    @PutMapping("/{flightId}/add-plane/{planeId}")
    void addPlaneToFlight(@PathVariable String flightId, @PathVariable String planeId){
        flightService.addPlaneToFlight(flightId,planeId);
    }

    @PutMapping("/{flightId}/add-destination/{airportId}")
    void addDestinationAirport(@PathVariable String flightId, @PathVariable String airportId){
        flightService.addDestinationAirport(flightId,airportId);
    }

    @PutMapping("/{flightId}/add-location/{airportId}")
    void addLocationAirport(@PathVariable String flightId, @PathVariable String airportId){
        flightService.addLocationAirport(flightId,airportId);
    }

    @GetMapping("/search-by")
    ResponseEntity<List<FlightDto>> getBySearchParams(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date departureDate, @RequestParam String location) {
        return ResponseEntity.ok(flightService.getBySearchParams(departureDate, location));
    } //iso date e format an-luna-zi

    @GetMapping("/search")
    Iterable<FlightDto> getByDepDateAndDestDateAndLocation(@Valid SearchParamFlightDto searchParamDto) {
        return flightService.getByDepDateAndDestDateAndLocation(searchParamDto);
    }

    @GetMapping("/find")
    Iterable<FlightDtoView> getByDestinationIdAndLocationIdAirport(@Valid SearchParamsFlightDtoView searchParamDto) {
        return flightService.getByLocationIdAndDestinationIdAirport(searchParamDto);
    }

    @GetMapping("/all")
    Iterable<FlightDtoSimple> getAllFlights() {
        return flightService.getAllFlights();
    }
}
