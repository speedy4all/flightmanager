package com.p5.flightmanager.web;

import com.p5.flightmanager.service.api.PlaneService;
import com.p5.flightmanager.service.dto.PlaneDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
@Transactional
@Consumes("application/json")
@Produces("application/json")
@RequestMapping("/planes")
public class PlaneController {

    @Autowired
    PlaneService planeService;

    @GetMapping
    ResponseEntity<List<PlaneDto>> getAll(@RequestParam String search) {

        return ResponseEntity.ok(planeService.getAll(search));
    }

    @GetMapping("/{id}")
    ResponseEntity<PlaneDto> getById(@PathVariable String id)
    {
        return ResponseEntity.ok(planeService.getById(id));
    }

    @PostMapping
    ResponseEntity<PlaneDto> createAirport(@RequestBody PlaneDto airportDto) {

        return ResponseEntity.ok(planeService.createPlane(airportDto));
    }

    @PutMapping
    ResponseEntity<PlaneDto> updateAirport (@RequestBody PlaneDto airportDto) {

        return ResponseEntity.ok(planeService.updatePlane(airportDto));
    }

    @DeleteMapping("/{iddelete}")
    void deleteAirport(@PathVariable String iddelete) {
        planeService.deletePlane(iddelete);
    }


}
