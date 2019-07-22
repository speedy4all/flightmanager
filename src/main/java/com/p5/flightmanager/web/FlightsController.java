package com.p5.flightmanager.web;


import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.dto.FlightDto;
import com.p5.flightmanager.service.dto.FlightSearchDto;
import com.p5.flightmanager.service.dto.FlightSimpleDto;
import com.p5.flightmanager.service.dto.FlightUpdateDto;
import com.p5.flightmanager.service.exceptions.RestExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

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

    // departureId, destinationId, departureDate
    @GetMapping
    ResponseEntity<List<FlightSimpleDto>> getAll(FlightSearchDto search) {
        return ResponseEntity.ok(flightService.searchBy(search));
    }

    @GetMapping("/search-by")
    ResponseEntity<List<FlightDto>> getBySearchParams(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date departureDate, @RequestParam String location, @RequestParam String destination) {
        return ResponseEntity.ok(flightService.getBySearchParams(departureDate, location, destination));
    }

    @GetMapping("/{id}")
    ResponseEntity<FlightDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(flightService.getById(id));
    }

    @GetMapping("/simple-list")
    ResponseEntity<Iterable<FlightSimpleDto>> getSimpleFlightDto() {
        return ResponseEntity.ok(flightService.getSimpleFlightDto());
    }

    @PostMapping
    ResponseEntity<FlightDto> createFlight(@RequestBody FlightDto flightDto) {
        return ResponseEntity.ok(flightService.createFlight(flightDto));
    }

    @PutMapping()
    void updateFlight(@RequestBody FlightUpdateDto flightUpdateDto) {
        flightService.addPassenger(flightUpdateDto);
    }

    @DeleteMapping("/{id}")
    void deleteFlight(@PathVariable String id) {
        flightService.deleteFlight(id);
    }

    @PutMapping("/{flightId}/add-passenger/{passengerId}")
    void addPassengerToFlight(@PathVariable String flightId, @PathVariable String passengerId){
        flightService.addPassengerToFlight(flightId, passengerId);
    }

    @PutMapping("/{flightId}/associate-plane/{planeId}")
    void associatePlaneToFlight(@PathVariable String flightId, @PathVariable String planeId){
        flightService.associatePlaneToFlight(flightId, planeId);
    }

    //TODO: endpoint pentru a seta departure si destination (in functie de IATA aeroportului); DONE
    @PutMapping("/{flightId}/set-departure-destination/{departureAirportIata}/{destinationAirportIata}")
    void setDepartureAndDestinationAirport(@PathVariable String flightId, @PathVariable String departureAirportIata, @PathVariable String destinationAirportIata ){
        flightService.setDepartureAndDestinationAirport(flightId, departureAirportIata, destinationAirportIata);
    }
}
