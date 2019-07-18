package com.p5.flightmanager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = "com.p5.flightmanager.repository.models")
@EnableJpaRepositories(basePackages = "com.p5.flightmanager.repository")
public class FlightmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightmanagerApplication.class, args);
    }

}

//TODO: pe flight 1 plane (ManyToOne);
//TODO: pe flight 2 airports (departure, destination);
//TODO: pe airport ManyToMany : airport-flight; metoda de a asigna unui aeroport un flight (lista de flight-uri);