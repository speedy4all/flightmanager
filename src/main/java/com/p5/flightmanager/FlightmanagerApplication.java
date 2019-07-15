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


/*

{
    "firstName": "Lorena-Ionela",
    "lastName": "Pavel",
    "npc": "2981110080045",
    "birthDate": "1998-10-11"
}



{
    "id": "8db2cc3e-9693-4deb-abe2-1005448f9029",
    "name": "Second flight",
    "departureLocation": "BUH",
    "destinationLocation": "CJ",
    "durationTime": 8,
    "fullFlightDescription": "BUH-CJ",
    "departureDate": "2019-07-11",
    "destinationDate": "2019-07-11"
}



 */