package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Passenger;
import com.p5.flightmanager.service.dto.FlightUpdateDto;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface PassengerRepository extends CrudRepository<Passenger, UUID> {

    @Query("select p from Passenger p where lower(second_name) like concat('%', lower(?1), '%')")
    Iterable<Passenger> filterByName(String search);

    @Query("select p from Passenger p where p.identifyNumber=:uniqueIdentifier")
    Optional<Passenger> getByUniqueIdentifier(String uniqueIdentifier);

    Passenger getByIdentifyNumber(String identifyNumber);
}