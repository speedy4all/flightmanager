package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Plane;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlanesRepository extends CrudRepository<Plane, UUID> {

    @Query("select x from Plane x where lower(name) like concat('%',lower(?1),'%')")
    Iterable<Plane> filterByName(String search);
}