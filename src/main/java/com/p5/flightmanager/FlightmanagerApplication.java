package com.p5.flightmanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
@EntityScan(basePackages = "com.p5.flightmanager") //in ce director va scana
@EnableJpaRepositories(basePackages = "com.p5.flightmanager") //pentru a putea accesa datele
public class FlightmanagerApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(FlightmanagerApplication.class, args);
    }

}
