package com.swen.doordashapi.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

import org.springframework.stereotype.Indexed;

@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserTypes type;

//    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
//    private Session session;

    /**
     * Defualt contructor used by JPA (not called by our code)
     */
    public User() {
    }

     public User(Long id, String name, String password, UserTypes type) {
         this.id = id;
         this.name = name;
         this.password = password;
         this.type = type;
     }

    public Long getId() {
        return id;
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
