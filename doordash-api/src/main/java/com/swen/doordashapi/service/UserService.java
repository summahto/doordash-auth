package com.swen.doordashapi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.swen.doordashapi.model.LoginRequest;
import com.swen.doordashapi.model.Session;
import com.swen.doordashapi.model.User;
import com.swen.doordashapi.repository.SessionRepository;
import com.swen.doordashapi.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    SessionRepository sessionRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id) {
        return userRepository.findById(id);
    }

    public Optional<User> findByName(String name) {
        return userRepository.findByName(name);
    }

    public User save(User user) {
        return userRepository.save(user);
    }

    public Session login(String name, String password) {
        User user = userRepository.findByCredentials(name, password);

        if (user != null) {
            // Create a new session and associate it with the user
            Session session = new Session(user.getId());
            return sessionRepository.save(session);
        } else {
            throw new RuntimeException("Invalid credentials");
        }
    }

    public void logout(Session session) {
        sessionRepository.delete(session);
    }

    public Optional<Session> findSession(String sessionID) {
        return sessionRepository.findById(sessionID);
    }

}
