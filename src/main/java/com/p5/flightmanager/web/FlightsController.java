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

//    @GetMapping
//    ResponseEntity<List<FlightDto>> getAll(@RequestParam String search) {
//
//        return ResponseEntity.ok(flightService.getAll(search));
//    }

    @GetMapping
    ResponseEntity<List<FlightDtoView>> getAll(@RequestParam String search) {

        return ResponseEntity.ok(flightService.getAll(search));
    }

    @GetMapping("/search-by")
    ResponseEntity<List<FlightDto>> getBySearchParams(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date departureDate, @RequestParam String location, @RequestParam String destination) {
        return ResponseEntity.ok(flightService.getBySearchParams(departureDate, location, destination));
    }

    @PutMapping("/add")
    void flightUpdate(@RequestBody  FlightUpdateDto flightUpdateDto){
        flightService.addPassengerDto(flightUpdateDto);
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
        //return ResponseEntity.ok("Update flight");

    }

    @DeleteMapping("/{id}")
    void deleteFlight(@PathVariable String id) {
        flightService.deleteFlight(id);
    }

    @PutMapping("/{flightId}/add-passenger/{passengerId}")
    void addPassengerToFlight(@PathVariable String flightId, @PathVariable String passengerId){
        flightService.addPassengerToFlight(flightId, passengerId);
    }

    @PutMapping("/{flightId}/add--passenger/{passengerId}")
    void addPassenger(@PathVariable String flightId, @PathVariable String passengerId){
        flightService.addPassenger(flightId, passengerId);
    }

    @GetMapping("/search")
    Iterable<FlightDtoSimple> getByDepDateAndDestDateAndLocation(@Valid SearchParamDto searchParamDto) {
        return flightService.getByDepDateAndDestDateAndLocation(searchParamDto);
    }

    @GetMapping("/offers")
    Iterable<FlightDtoView> getOffers(){
        return flightService.getAllOffers();
    }

//    @GetMapping("/search1")
//    Iterable<FlightDtoParamSearch> getByDepIdAndDestIdAndDepDate(@Valid SearchParamDtoFlight searchParamDtoFlight){
//        return flightService.getByDepIdAndDestIdAndDepDate(searchParamDtoFlight);
//    }
}