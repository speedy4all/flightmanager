package com.p5.flightmanager;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/flights")
@Consumes("application/json")
@Produces("application/json")
@Transactional
public class FlightsController {

    @Resource
    private FlightsRepository flightsRepository;

    @GetMapping
    ResponseEntity<Iterable<Flight>> getAll() {
        return ResponseEntity.ok(flightsRepository.findAll());
    }
}