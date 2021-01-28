package com.harden.backend_study;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class BackendStudyApplication {

    public static void main(String[] args) {
        SpringApplication.run(BackendStudyApplication.class, args);
    }

}
