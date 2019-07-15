package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Passenger;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PassengerRepository extends CrudRepository<Passenger, UUID> {

    @Query("select p from Passenger p where lower(second_name) like concat('%', lower(?1), '%')")
    Iterable<Passenger> filterByName(String search);
}
