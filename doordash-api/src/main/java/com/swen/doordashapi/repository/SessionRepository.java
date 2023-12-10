package com.swen.doordashapi.repository;
import com.swen.doordashapi.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;

import com.swen.doordashapi.model.User;

public interface SessionRepository extends JpaRepository<Session, String>{
    Session findBySessionID(String id);
}
