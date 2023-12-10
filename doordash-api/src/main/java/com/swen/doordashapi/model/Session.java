package com.swen.doordashapi.model;

import java.util.Random;

import jakarta.persistence.*;


@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String sessionID;
    private Long user_id;


    public Session() {

    }

    public Session(Long user_id) {
        this.user_id = user_id;
    }


}
