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
@Transactional //im momentul in care s-a mapat metodele din clasa vor primi o tranzactie noua de fiecare data cand o metoda este apelata
//la fiecare metoda se dechide cate o tranzactie
public class FlightController extends RestExceptionHandler {

    @Autowired
    private FlightService flightService;

    /**
     * returns a list of flights that have the requirements
     * @param search
     * @return
     */
    @GetMapping
    ResponseEntity<ListResponseDto<ResponseFlightDto>> getAll(SearchParamsFlight search) {
        return ResponseEntity.ok(flightService.searchBy(search));
    }

    @GetMapping("/search-by")
    ResponseEntity<List<FlightDto>> getBySearchParams(@RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) Date departureDate, @RequestParam String location) {
        return ResponseEntity.ok(flightService.getBySearchParams(departureDate, location));
    } //iso date e format an-luna-zi

    /**
     * returns a list of flights that have the required name
     * @param name
     * @return
     */
    @GetMapping("/search")
    ResponseEntity<ListResponseDto<ResponseFlightDto>> getAllByName(@QueryParam("name") String name) {

        return ResponseEntity.ok(flightService.getAllByName(name));
    }

    @GetMapping("/all")
    ListResponseDto<ResponseFlightDto> getAllFlights() {
        return flightService.getAllFlights();
    }

    @GetMapping("/offers")
    ListResponseDto<ResponseFlightDto> getOffers() {
        return flightService.getOffers();
    }

//    @GetMapping
//    List<FlightDtoView> getAll(SearchParamsFlight search) {
//        return flightService.searchBy(search);
//    }

    @GetMapping("/my-flights/{id}")
    ResponseEntity<ListResponseDto<ResponseFlightDto>> getAllMyFlights (@PathVariable String id) {
        return ResponseEntity.ok(flightService.getAllMyFlights(id));
    }

    /**
     * returns a flight with the given id
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    ResponseEntity<FlightDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(flightService.getById(id));
    }

    @PostMapping
    ResponseEntity<FlightDto> createFlight(@RequestBody PostFlightDto postFlightDto) {
        return ResponseEntity.ok(flightService.createFlight(postFlightDto));
    }

    //de mine
//    @PutMapping
//    ResponseEntity<FlightDto> updateFlight(@RequestBody FlightDto flightDto) {
//        return ResponseEntity.ok(flightService.updateFlight(flightDto));
//    }

    @PutMapping
    void updateFlight(@RequestBody FlightUpdateDto flightDto) {
        flightService.addPassenger(flightDto);
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

    @PutMapping("/{flightId}/add-passenger/{passengerId}")
    void addPassengerToFlight(@PathVariable String flightId, @PathVariable String passengerId) {
        flightService.addPassengerToFlight(flightId,passengerId);
    }

    @DeleteMapping("/{iddelete}")
    void deleteFlight(@PathVariable String iddelete) {
        flightService.deleteFlight(iddelete);
    }

    @DeleteMapping("/{flightId}/remove/{personalId}")
    void removePasenger(@PathVariable String flightId, @PathVariable String personalId) {
        flightService.deletePassenger(flightId, personalId);
    }
}
