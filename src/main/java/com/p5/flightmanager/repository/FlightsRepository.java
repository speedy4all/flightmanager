package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FlightsRepository extends CrudRepository<Flight, UUID> {
    Iterable<Flight> getAllByNameIsContaining(String name);

    @Query("select f from Flight f where lower(name) like lower(CONCAT('%',lower(?1),'%'))")
    Iterable<Flight> filterByName(String search);
}
