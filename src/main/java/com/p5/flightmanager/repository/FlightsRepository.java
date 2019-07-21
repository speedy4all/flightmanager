package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.service.dto.FlightDtoSearch;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

@Repository
public interface FlightsRepository extends CrudRepository<Flight, UUID> {

    Iterable<Flight> getAllByNameIsContaining(String name);

    @Query("select f from Flight f where lower(name) like concat('%', lower(?1), '%')")
    Iterable<Flight> filterByName(String search);


    @Query("select f from Flight f where f.departureDate=:departureDate and f.departureLocation=:location and f.destinationLocation=:destination")
    Iterable<Flight> getBySearchParams(Date departureDate, String location, String destination);


    @Query("select f from Flight f " +
            "join f.departureLocation a " +
            "where f.departureDate=:departureDate and a.city=:departureLocation")
    Iterable<Flight> findByDateAndName(Date departureDate, String departureLocation);


    @Query("select new com.p5.flightmanager.service.dto.FlightDtoSearch(flight.name, departureAirport.city, destinationLocation.city) from Flight flight " +
            "join flight.departureLocation departureAirport " +
            "join flight.destinationLocation destinationLocation " +
            "where flight.departureDate=:departureDate and departureAirport.city=:departureLocation")
    Iterable<FlightDtoSearch> findByNameAndDAteSimple(Date departureDate, String departureLocation);

}