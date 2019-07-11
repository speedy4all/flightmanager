package com.p5.flightmanager.Repository;

import com.p5.flightmanager.Repository.Models.Flight;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FlightsRepository extends CrudRepository<Flight, UUID> {
}
