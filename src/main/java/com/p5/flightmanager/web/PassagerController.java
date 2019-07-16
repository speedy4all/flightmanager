package com.p5.flightmanager.web;

import com.p5.flightmanager.service.api.PassagerService;
import com.p5.flightmanager.service.dto.PassagerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import java.util.List;

@RestController
@RequestMapping("/passager")
@Consumes("application/json")
@Produces("application/json")

public class PassagerController {

    @Autowired
    private PassagerService passagerService;

    @GetMapping
    ResponseEntity<List<PassagerDto>> getAll(@RequestParam String search){
    return ResponseEntity.ok(passagerService.getAll(search));}

    @GetMapping("/{id}")
    ResponseEntity<PassagerDto> getById(@PathVariable String id) {
        return ResponseEntity.ok(passagerService.getById(id));
    }
    @PostMapping
    ResponseEntity<PassagerDto> createPassager(@RequestBody PassagerDto passagerDto){
    return ResponseEntity.ok(passagerService.createPassager(passagerDto));

    }
    @PutMapping("/update")
    ResponseEntity<PassagerDto> updatePassager(@RequestBody PassagerDto passagerDto){
        return ResponseEntity.ok(passagerService.updatePassager(passagerDto));

    }
    @DeleteMapping("/{id}")
    void deletePassager(@PathVariable String id){
        passagerService.deletePassager(id);
    }

}
