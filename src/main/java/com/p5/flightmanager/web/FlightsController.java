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
import javax.ws.rs.QueryParam;
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

    //anuleaza o rezervare
    @PutMapping("/cancel-reservation/{flightId}/{identifier}")
    ResponseEntity<FlightSearchCancelDto> cancelReservation(@RequestBody FlightSearchCancelDto flightSearchCancelDto){
        flightService.cancelReservation(flightSearchCancelDto);
        return ResponseEntity.ok(flightSearchCancelDto);
    }

    //lista de flighturi ale unui pasager
    @GetMapping("/{identifier}/my-flights")
    ResponseEntity<ListResponseDto<ResponseFlightDto>> getMyFlights(@PathVariable String uniqueIdentifier){
        return  ResponseEntity.ok(flightService.getMyFlights(uniqueIdentifier));
    }

    //lista de flighturi disponibile cu toate proprietatile
    @GetMapping("/offers")
    ResponseEntity<ListResponseDto<ResponseFlightDto>> getAllFullFlights(){
        return ResponseEntity.ok(flightService.getAllFullFlights());
    }

    @GetMapping
    ResponseEntity<ListResponseDto<ResponseFlightDto>> getAll(FlightSearchDto searchDto) {

        return ResponseEntity.ok(flightService.searchBy(searchDto));
    }

    @GetMapping("/search")
    ResponseEntity<ListResponseDto<ResponseFlightDto>> getAllByName(@QueryParam("name") String name) {

        return ResponseEntity.ok(flightService.getAll(name));
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

}
