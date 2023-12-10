package com.swen.doordashapi.repository;

import com.swen.doordashapi.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findById(Long id);

    Optional<User> findByName(String name);

    User save(User user);

    List<User> findAll();

    @Query("SELECT b FROM User b WHERE b.name = :name AND b.password = :password AND b.type = :type")
    User login(@Param("name") String name, @Param("password") String password, @Param("type") int type);
}