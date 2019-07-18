package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Plane;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlaneRepository extends CrudRepository<Plane, UUID> {

    @Query("select p from Plane p where lower(companyName) like concat('%',lower(?1),'%')")
    Iterable<Plane> filterByName(String search);
}