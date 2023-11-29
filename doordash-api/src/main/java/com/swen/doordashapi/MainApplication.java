package com.swen.doordashapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.swen.doordashapi.repository.UserRepository;

@SpringBootApplication
public class MainApplication {

    MainApplication(String[] args) {
        if (args[0] == "preload") {

        }
    }
    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

    @Autowired
    UserRepository userRepository;

}
