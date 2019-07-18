package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.service.dto.AirportDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AirportsRepository extends CrudRepository<Airport, UUID> {

    @Query("select f from Airport f where lower(code) like concat('%',lower(?1),'%')")
    Iterable<Airport> filterByLocation(String search);

//    @Query("select new p5.flightmanager.service.dto.AirportDto(airport.id, airport.name, airport.city) from Airport airport where airport.id=:id and" +
//            "airport.name=:name and airport.city=:city")
    Iterable<AirportDto> filterByIdAndNameAndCity(String id, String name, String city);
}
