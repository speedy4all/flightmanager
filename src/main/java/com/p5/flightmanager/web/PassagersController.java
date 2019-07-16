package com.p5.flightmanager.web;

import com.p5.flightmanager.service.api.PassengersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping("/passagers")
@Consumes("application/json")
@Produces("application/json")
@Transactional
public class PassagersController {

    @Autowired
    private PassengersService passengersService;

    @GetMapping
    ResponseEntity<List<PassengersDto>> getAll(@RequestParam String search) {
        return ResponseEntity.ok(passengersService.getAll(search));
    }

    @GetMapping("/{id}")
    ResponseEntity<PassengersDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(passengersService.getById(id));
    }

    @PostMapping
    ResponseEntity<PassengersDto> createPassager(@RequestBody PassengersDto passengersDto) {
        return ResponseEntity.ok(passengersService.createPassager(passengersDto));
    }

    @PutMapping("/update")
    ResponseEntity<PassengersDto> updatePassager(@RequestBody PassengersDto passengersDto){
        return ResponseEntity.ok(passengersService.updatePassager(passengersDto));
    }

    @DeleteMapping("/{id}")
    void deletePassager(@PathVariable String id){
        passengersService.deletePassager(id);
    }
}
