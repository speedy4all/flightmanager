package com.p5.flightmanager.web;

import com.p5.flightmanager.service.api.PassengerService;
import com.p5.flightmanager.service.dto.FlightDto;
import com.p5.flightmanager.service.dto.PassengerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/passengers")
@Consumes("application/json")
@Produces("application/json")
@Transactional
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @GetMapping
    ResponseEntity<List<PassengerDto>> getAll(@RequestParam String firstName) {
        return ResponseEntity.ok(passengerService.getAll(firstName));
    }

    @PostMapping
    ResponseEntity<PassengerDto> createPassenger(@RequestBody PassengerDto passengerDto) {
        return ResponseEntity.ok(passengerService.createPassenger(passengerDto));
    }
}
