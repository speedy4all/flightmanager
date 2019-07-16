package com.p5.flightmanager.web;

import com.p5.flightmanager.service.api.AirplaneService;
import com.p5.flightmanager.service.dto.AirplaneDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping("/airplanes")
@Consumes("application/json")
@Produces("application/json")
@Transactional
public class AirplaneController {

    @Autowired
    private AirplaneService airplaneService;

    @GetMapping
    ResponseEntity<List<AirplaneDto>> getAll(@RequestParam String search) {

        return ResponseEntity.ok(airplaneService.getAll(search));
    }

    @GetMapping("/{id}")
    ResponseEntity<AirplaneDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(airplaneService.getById(id));
    }

    @PostMapping
    ResponseEntity<AirplaneDto> createAirplane(@RequestBody AirplaneDto airplaneDto) {
        return ResponseEntity.ok(airplaneService.createAirplane(airplaneDto));
    }

    @PutMapping("/update")
    ResponseEntity<AirplaneDto> updateAirplane(@RequestBody AirplaneDto airplaneDto) {
        return ResponseEntity.ok(airplaneService.updateAirplane(airplaneDto));
        //return ResponseEntity.ok("Update flight");
    }

    @DeleteMapping("/{id}")
    void deleteAirplane(@PathVariable String id) {
        airplaneService.deleteAirplane(id);
    }
}
