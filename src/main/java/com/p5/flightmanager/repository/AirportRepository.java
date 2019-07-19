package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.service.dto.AirportDtoSimple;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface AirportRepository extends CrudRepository<Airport, UUID> {

    @Query("select a from Airport a where lower(name) like concat('%', lower(?1), '%')")
    Iterable<Airport> filterByName(String search);

    Optional<Airport> findByCity(String name);

    @Query("select new com.p5.flightmanager.service.dto.AirportDtoSimple(airport.name, airport.iata, airport.city) from Airport airport")
    Iterable<AirportDtoSimple> findAirportNameIataAndCity();

    @Query("select a from Airport a where lower(iata) like concat('%', lower(?1), '%')")
    Optional<Airport> findByIata(String iata);
}
