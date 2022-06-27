package com.example.smartcontactmanagerproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication  // trigger auto config, component scan and many annotation auto
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
