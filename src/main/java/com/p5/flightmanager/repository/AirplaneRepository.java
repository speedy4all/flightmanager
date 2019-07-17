package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Airplane;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface AirplaneRepository extends CrudRepository<Airplane, UUID> {

    @Query("select plane from Airplane plane where lower(name) like concat('%', lower(?1), '%')")
    Iterable<Airplane> filterByName(String search);
}
