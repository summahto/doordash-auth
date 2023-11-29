package com.swen.doordashapi.repository;

import com.swen.doordashapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByID(Long id);

    Optional<User> findByName(String name);

    User save(User user);

    List<User> findAll();
}