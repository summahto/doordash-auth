package com.swen.doordashapi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

import org.springframework.stereotype.Indexed;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;
    private String token;
    private UserTypes type;

    /**
     * Defualt contructor used by JPA (not called by our code)
     */
    public User() {}

    // /**
    //  * Might not be used but this will allow us to preload data into the system
    //  * 
    //  * TODO: look into how to get this to put this into the db
    //  * @param id
    //  * @param name
    //  * @param password
    //  * @param token
    //  * @param type
    //  */
    // public User(Long id, String name, String password, String token, UserTypes type) {
    //     this.id = id;
    //     this.name = name;
    //     this.password = password;
    //     this.token = token;
    //     this.type = type;
    // }
}
