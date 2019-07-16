package com.p5.flightmanager.web;

import com.p5.flightmanager.service.api.AiplaneService;
import com.p5.flightmanager.service.dto.AirplaneDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping("/planes")
@Consumes("application/json")
@Produces("application/json")
@Transactional
public class AiplaneController {

    @Autowired
    private AiplaneService aiplaneService;

    @GetMapping
    ResponseEntity<List<AirplaneDto>> getAll(@RequestParam String search) {
        return ResponseEntity.ok(aiplaneService.getAll(search));
    }

    @GetMapping("/{id}")
    ResponseEntity<AirplaneDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(aiplaneService.getById(id));
    }

    @PostMapping
    ResponseEntity<AirplaneDto> createPlane(@RequestBody AirplaneDto airplaneDto) {
        return ResponseEntity.ok(aiplaneService.createPlane(airplaneDto));
    }

    @PutMapping("/update")
    ResponseEntity<AirplaneDto> updatePlane(@RequestBody AirplaneDto airplaneDto) {
        return ResponseEntity.ok(aiplaneService.updatePlane(airplaneDto));
    }

    @DeleteMapping("/{id}")
    void deletePlane(@PathVariable String id) {
        aiplaneService.deletePlane(id);
    }
}
