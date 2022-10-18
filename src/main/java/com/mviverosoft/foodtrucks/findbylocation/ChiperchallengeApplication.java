package com.mviverosoft.foodtrucks.findbylocation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ChiperchallengeApplication {

    public static final String PATH_SERVICE = "/api/V1.0";

    public static void main(String[] args) {
        
        SpringApplication.run(ChiperchallengeApplication.class, args);
    }

}
