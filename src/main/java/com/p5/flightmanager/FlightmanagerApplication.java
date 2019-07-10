package com.p5.flightmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class FlightmanagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(FlightmanagerApplication.class, args);
    }

}
