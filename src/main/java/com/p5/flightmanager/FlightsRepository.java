package com.p5.flightmanager;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FlightsRepository extends CrudRepository<Flight, String> {
}