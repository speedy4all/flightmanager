package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.service.dto.FlightDtoSimple;
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

    @Query("select f from Flight f where f.departureDate=:departureDate " +
            "and f.departureAirport.city=:location " +
            "and f.destinationAirport.city=:destination")
    Iterable<Flight> getBySearchParams(Date departureDate, String location, String destination);

    @Query("select f from Flight f " +
            "join f.departureAirport a " +
            "where f.departureDate=:departureDate and a.city=:departureLocation")
    Iterable<Flight> findByDateAndName(Date departureDate, String departureLocation);

    //TODO: lista de flight-uri care sa contina id-ul flight-ului, numele flight-ului, departure&destination date&city; DONE
    @Query("select new com.p5.flightmanager.service.dto.FlightDtoSimple(flight.id, flight.name, flight.departureDate, depAirport.city, flight.destinationDate, desAirport.city) from Flight flight " +
            "inner join flight.departureAirport depAirport on depAirport.city=:departureLocation " +
            "inner join flight.destinationAirport desAirport on desAirport.city=:destinationLocation " +
            "where flight.departureDate=:departureDate and flight.destinationDate=:destinationDate")
    Iterable<FlightDtoSimple> findByDepartureAndDestinationDateAndLocation(String departureLocation, Date departureDate, String destinationLocation, Date destinationDate);
}