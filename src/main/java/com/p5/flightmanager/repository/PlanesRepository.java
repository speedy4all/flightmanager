package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Plane;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PlanesRepository extends CrudRepository<Plane, UUID> {

    @Query("select l from Plane l where lower(plane_model) like concat('%', lower(?1), '%')")
    Iterable<Plane> filterByModel(String search);
}
