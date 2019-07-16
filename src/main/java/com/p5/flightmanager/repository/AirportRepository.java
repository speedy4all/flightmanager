package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Airport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AirportRepository  extends CrudRepository<Airport, UUID> {

    @Query("select a from Airport a where lower(name) like concat('%', lower(?1), '%')")
    Iterable<Airport> filterByName(String search);
}
