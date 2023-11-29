package com.swen.doordashapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.swen.doordashapi.model.User;
import com.swen.doordashapi.repository.UserRepository;

public class UserService {

    @Autowired UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findByID(id);
    }

    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    public User save(User user) {
        return userRepository.save(user);
    }
    
}
