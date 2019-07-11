package com.p5.flightmanager.Web;

import com.p5.flightmanager.Repository.Models.Flight;
import com.p5.flightmanager.Service.api.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping("/flights")
@Consumes("application/json")
@Produces("application/json")
@Transactional
public class FlightsController {

    @Autowired
    private FlightService flightService;

    @GetMapping
    ResponseEntity<List<Flight>> getAll(){
        return ResponseEntity.ok(flightService.getAll());
    }
    @PostMapping
    ResponseEntity<Flight> createFlight(){
        return ResponseEntity.ok(flightService.createFlight());
    }

}
