package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Airplane;
import com.p5.flightmanager.repository.models.Airport;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AirplaneRepository extends CrudRepository<Airplane, UUID> {

    Iterable<Airplane> getAllByNameIsContaining(String name);

    @Query("select f from Flight f where lower(name) like concat('%', lower(?1), '%')")
    Iterable<Airplane> filterByName(String search);


}