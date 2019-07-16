package com.p5.flightmanager.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;
@Repository
public interface PassagerRepository extends CrudRepository<Passager, UUID> {
    Iterable<Passager>getAllByNameIsContaining(String name);


    @Query ("select p from Passager p where  like concat('%', lower(?1), '%')")
    Iterable<Passager> filterByName(String search);



}
