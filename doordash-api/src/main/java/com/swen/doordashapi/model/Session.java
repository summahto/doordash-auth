package com.swen.doordashapi.model;

import java.util.Random;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

public class Session {
    @Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    private Long token;
    private Long user_id;
    
    public Session() {

    }

    public Session(Long user_id) {
        this.user_id = user_id;
        this.token = new Random().nextLong();
    }

    
}
