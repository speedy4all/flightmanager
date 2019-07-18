package com.p5.flightmanager.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository

public interface AirportRepository  extends CrudRepository<Airport, UUID>{

    @Query("select a from Airport a where lower(name) like concat('%', lower(?1), '%')")
    Iterable<Airport> filterByName(String search);

}
