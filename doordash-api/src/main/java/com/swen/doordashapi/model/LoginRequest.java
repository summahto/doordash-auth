package com.swen.doordashapi.model;

public class LoginRequest {
    private String name;
    private String password;
    private UserTypes type;
    
    public LoginRequest() {
        
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public UserTypes getType() {
        return type;
    }
}