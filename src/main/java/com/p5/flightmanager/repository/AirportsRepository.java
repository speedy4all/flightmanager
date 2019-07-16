package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Airport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AirportsRepository extends CrudRepository<Airport, UUID> {

    @Query("select f from Airport f where lower(location) like concat('%',lower(?1),'%')")
    Iterable<Airport> filterByName(String search);
}
