package com.p5.flightmanager.service.dto.adapter;

import com.p5.flightmanager.repository.models.Passenger;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PassengersRepository extends CrudRepository<Passenger, UUID> {

    //Iterable<Passenger> getAllByNameIsContaining(String name);

    @Query("select p from Passenger p where lower(first_name) like concat('%', lower(?1), '%') or " +
            "lower(last_name) like concat('%', lower(?1), '%')")
    Iterable<Passenger> filterByFirstName(String search);
}
