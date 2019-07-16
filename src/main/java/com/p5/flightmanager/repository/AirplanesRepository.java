package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Airplanes;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AirplanesRepository extends CrudRepository<Airplanes, UUID> {

    @Query("select l from Airplanes l where lower(plane_model) like concat('%', lower(?1), '%')")
    Iterable<Airplanes> filterByModel(String search);
}
