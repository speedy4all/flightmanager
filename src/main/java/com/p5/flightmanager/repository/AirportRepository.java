package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.repository.models.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AirportRepository extends CrudRepository<Airport, UUID> {

    @Query("select a from Airport a where lower(name) like concat('%', lower(?1), '%')")
    Iterable<Airport> filterByName(String search);

    Optional<Airport> findByCity(String name);
}
