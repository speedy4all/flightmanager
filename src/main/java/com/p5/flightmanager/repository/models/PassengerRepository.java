package com.p5.flightmanager.repository.models;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface PassengerRepository extends CrudRepository<Passenger, UUID> {
    Iterable<Passenger>getAllByNameIsContaining (String name);

    @Query ("select f from Passengers f where lower(name) like concat('%', lower(?1), '%')")
    Iterable<Passenger> filterByName(String search);
}
