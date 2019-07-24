package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Passenger;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface PassengersRepository extends CrudRepository<Passenger, UUID> {

    @Query("select f from Passenger f where lower(firstName) like concat('%',lower(?1),'%') order by f.firstName")
    Iterable<Passenger> filterByFirstName(String search);

    @Query("select f from Passenger f where f.personalId=:uniqueIdentifier")
    Optional<Passenger> getByUniqueIdentifier(String uniqueIdentifier);

    Passenger getByPersonalId(String identifyNumber);

//    @Query("select a from Passenger a where a.personalID=:uniqueIdentifier")
//    List<Passenger> getAllPassengersByUniqueId(String uniqueIdentifier);
}
