package com.p5.flightmanager.web;

import com.p5.flightmanager.service.api.PlaneService;
import com.p5.flightmanager.service.dto.PlaneDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.xml.ws.Response;
import java.util.List;

@RestController
@RequestMapping("/planes")
@Consumes("application/json")
@Produces("application/json")
@Transactional
public class PlanesController {

    @Autowired
    private PlaneService planeService;

    @GetMapping
    ResponseEntity<List<PlaneDto>> getAll(@RequestParam String search) {
        return ResponseEntity.ok(planeService.getAll(search));
    }

    @GetMapping("/{id}")
    ResponseEntity<PlaneDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(planeService.getById(id));
    }

    @PostMapping
    ResponseEntity<PlaneDto> createPlane(@RequestBody PlaneDto planeDto) {
        return ResponseEntity.ok(planeService.createPlane(planeDto));
    }

    @PutMapping("/update")
    ResponseEntity<PlaneDto> updatePlane(@RequestBody PlaneDto planeDto) {
        return ResponseEntity.ok(planeService.updatePlane(planeDto));
    }

    @DeleteMapping("/{id}")
    void deletePlane(@PathVariable String id) {
        planeService.deletePlane(id);
    }
}
