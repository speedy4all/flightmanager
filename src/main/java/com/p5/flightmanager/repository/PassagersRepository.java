package com.p5.flightmanager.repository;

import com.p5.flightmanager.repository.models.Passager;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface PassagersRepository extends CrudRepository<Passager, UUID> {

    @Query("select p from Passager p where lower(last_name) like concat('%', lower(?1), '%')")
    Iterable<Passager> filterByName(String search);
}
