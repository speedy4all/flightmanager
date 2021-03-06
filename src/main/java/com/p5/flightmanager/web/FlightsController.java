package com.p5.flightmanager.web;


import com.p5.flightmanager.service.api.FlightService;
import com.p5.flightmanager.service.dto.CancelReservationDto;
import com.p5.flightmanager.service.dto.FlightDto;
import com.p5.flightmanager.service.dto.FlightDtoSimple;
import com.p5.flightmanager.service.dto.FlightSearchDto;
import com.p5.flightmanager.service.dto.FlightUpdateDto;
import com.p5.flightmanager.service.dto.ListResponseDto;
import com.p5.flightmanager.service.dto.ResponseFlightDto;
import com.p5.flightmanager.service.dto.SearchParamDto;
import com.p5.flightmanager.service.exceptions.RestExceptionHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.PathParam;
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

    @GetMapping
    ResponseEntity<ListResponseDto<ResponseFlightDto>> getAll(FlightSearchDto searchDto) {

        return ResponseEntity.ok(flightService.searchBy(searchDto));
    }

    @GetMapping("/{identifier}/my-flights")
    ResponseEntity<ListResponseDto<ResponseFlightDto>> getAllByIdentifier(@PathVariable String identifier) {

        return ResponseEntity.ok(flightService.getAll("Paris"));
    }

    @PutMapping("/cancel-reservation")
    ResponseEntity<CancelReservationDto> cancelReservation(@RequestBody CancelReservationDto cancelReservationDto) {

        return ResponseEntity.ok(flightService.cancelReservation(cancelReservationDto));
    }

    @GetMapping("/offers")
    ResponseEntity<ListResponseDto<ResponseFlightDto>> getAllOffers() {

        return ResponseEntity.ok(flightService.findAll());
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
