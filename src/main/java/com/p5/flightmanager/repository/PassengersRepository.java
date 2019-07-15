package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.repository.models.Passengers;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PassengersRepository extends CrudRepository<Passengers, UUID> {


    @Query("select p from Passengers p where lower (name) like concat('%',lower(?1),'%')")

    Iterable<Flight> filterByName(String search);
}
