package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Flight;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FlightsRepository extends CrudRepository<Flight, UUID> {
    //ar trebui sa fie case insensitive
    @Query("select f from Flight f where lower(name) like concat('%',lower(?1),'%') order by f.departureDate") //HQL - am voie sa introduc obiecte sau instante de obiect
    //primul f e obiect
    //f e alias
    Iterable<Flight> filterByName(String search);
}
