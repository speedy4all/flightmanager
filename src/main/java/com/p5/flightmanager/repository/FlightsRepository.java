package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Airport;
import com.p5.flightmanager.repository.models.Flight;
import com.p5.flightmanager.service.dto.FlightDto;
import com.p5.flightmanager.service.dto.FlightDtoSimple;
import com.p5.flightmanager.service.dto.ListResponseDto;
import com.p5.flightmanager.service.dto.ResponseFlightDto;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public interface FlightsRepository extends CrudRepository<Flight, UUID> {


    void cancelReservation(UUID flightId, UUID uniqueIdentifier);

    @Query("select new com.p5.flightmanager.service.dto.ResponseFlightDto(flight.id, departureAirport.city, departureAirport.iata, " +
            "destinationAirport.city, destinationAirport.iata, flight.departureDate, flight.destinationDate, plane.model, " +
            "flight.durationTime, plane.seats-flight.passengerList.size) from Flight flight " +
            "join flight.departureLocation departureAirport " +
            "join flight.destinationLocation destinationAirport " +
            "join flight.plane plane " +
            "join flight.passengerList list " +
            "where list.uniqueIdentifier=:uniqueIdentifier")
    ListResponseDto<ResponseFlightDto> findMyFlights(String uniqueIdentifier);

    //toate flighturile care mai au cel putin 5 locuri disponibile, data de plecare este mai mare decat daca curenta si in acelasi timp
    //data de plecare sa fie in cel mult 7 zile(pageable pentru a lua doar primele 10 flighturi)
    @Query("select new com.p5.flightmanager.service.dto.ResponseFlightDto(flight.id, departureAirport.city, departureAirport.iata, " +
            "destinationAirport.city, destinationAirport.iata, flight.departureDate, flight.destinationDate, plane.model, " +
            "flight.durationTime, plane.seats-flight.passengerList.size) from Flight flight" +
            "join flight.departureLocation departureAirport" +
            "join flight.destinationLocation destinationAirport" +
            "join flight.plane plane" +
            "where flight.passengerList.size<=5 and flight.departureDate>now() and flight.departureDate<:endDate")
    ListResponseDto<ResponseFlightDto> findAllFullFlights(Date endDate, Pageable pageable);

    Iterable<Flight> getAllByNameIsContaining(String name);

    @Query("select f from Flight f where lower(name) like concat('%', lower(?1), '%')")
    Iterable<Flight> filterByName(String search);


    @Query("select f from Flight f where f.departureDate=:departureDate and f.departureLocation=:location and f.destinationLocation=:destination")
    Iterable<Flight> getBySearchParams(Date departureDate, String location, String destination);


    @Query("select f from Flight f " +
            "join f.departureLocation a " +
            "where f.departureDate=:departureDate and a.city=:departureLocation")
    Iterable<Flight> findByDateAndName(Date departureDate, String departureLocation);


    @Query("select new com.p5.flightmanager.service.dto.FlightDtoSimple(flight.name, departureAirport.city, destAirport.city) from Flight flight " +
            "join flight.departureLocation departureAirport " +
            "join flight.destinationLocation destAirport " +
            "where flight.departureDate=:departureDate and departureAirport.city=:departureLocation")
    Iterable<FlightDtoSimple> findByNameAndDAteSimple(Date departureDate, String departureLocation);


    @Query("select distinct new com.p5.flightmanager.service.dto.ResponseFlightDto(f.id, departure.name, departure.iata, destination.name, destination.iata, f.departureDate, f.destinationDate, plane.model, f.durationTime, plane.seats - f.passengerList.size) from Flight f " +
            "join f.departureLocation departure " +
            "join f.destinationLocation destination " +
            "join f.passengerList passengers " +
            "join f.plane plane " +
            "where departure.id=:departureId and destination.id=:destinationId and f.departureDate=:departureDate order by f.departureDate desc")
    Iterable<ResponseFlightDto> getByDepartureIdAndDestinationIdAndDepartureDate(UUID departureId, UUID destinationId, Date departureDate);

}