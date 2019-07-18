package com.p5.flightmanager.web;

import com.p5.flightmanager.service.api.AirportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;

@RestController
@RequestMapping("/airports")
@Transactional
@Consumes("application/json")
@Produces("/application/json")

public class AirportController {
    @Autowired
    private AirportService airportService;
    @GetMapping
    ResponseEntity<List<AirportDto>> getAll
}
