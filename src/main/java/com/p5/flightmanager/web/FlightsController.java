package com.p5.flightmanager.web;


import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.dto.*;
import com.p5.flightmanager.service.exceptions.RestExceptionHandler;
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
@RequestMapping("/flight")
@Consumes("application/json")
@Produces("application/json")
@Transactional
public class FlightsController extends RestExceptionHandler {

    @Autowired
    private FlightService flightService;

    @GetMapping
    ResponseEntity<ListResponseDto<ResponseFlightDto>> getAll(FlightSearchDto searchDto) {

        return ResponseEntity.ok(flightService.searchBy(searchDto));
    }

    @GetMapping("/search-by")
    ResponseEntity<List<FlightDto>> getBySearchParams(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date departureDate, @RequestParam String location, @RequestParam String destination) {
        return ResponseEntity.ok(flightService.getBySearchParams(departureDate, location, destination));
    }

    @GetMapping("/{id}")
    ResponseEntity<FlightDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(flightService.getById(id));
    }

    @PostMapping
    ResponseEntity<FlightDto> createFlight(@RequestBody FlightDto flightDto) {
        return ResponseEntity.ok(flightService.createFlight(flightDto));
    }

    @PutMapping()
    ResponseEntity<FlightDto> updateFlight(@RequestBody FlightUpdateDto flightUpdateDto) {
        return ResponseEntity.ok(flightService.addPassenger(flightUpdateDto));
    }

    @DeleteMapping("/{id}")
    void deleteFlight(@PathVariable String id) {
        flightService.deleteFlight(id);
    }

    @PutMapping("/{flightId}/add-passenger/{passengerId}")
    void addPassengerToFlight(@PathVariable String flightId, @PathVariable String passengerId){
        flightService.addPassengerToFlight(flightId, passengerId);
    }

    @GetMapping("/search")
    Iterable<FlightDtoSimple> getByDepDateAndDestDateAndLocation(@Valid SearchParamDto searchParamDto) {
        return flightService.getByDepDateAndDestDateAndLocation(searchParamDto);
    }
}
