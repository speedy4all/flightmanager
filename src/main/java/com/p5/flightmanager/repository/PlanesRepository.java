package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Passenger;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PlanesRepository extends CrudRepository<Passenger, UUID> {

}
