package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Passenger;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PassengersRepository extends CrudRepository<Passenger, UUID> {
}
