package com.swen.doordashapi.contoller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.swen.doordashapi.model.User;
import com.swen.doordashapi.service.UserService;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	/* likely not necessary */
	@GetMapping
	public List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping("/users/{id}")
	public Optional<User> findById(@PathVariable Long id) {
		return userService.findById(id);
	}

	@GetMapping("/users/{name}")
	public Optional<User> findByName(@PathVariable String name) {
		return userService.findByName(name);
	}

	@ResponseStatus(HttpStatus.CREATED) // 201
	@PostMapping("/users")
	public User create(@RequestBody User user) {
		return userService.save(user);
	}

	@PutMapping("/users")
	public User update(@RequestBody User user) {
		return userService.save(user);
	}

	@PutMapping("/users/login")
	public Long login(@RequestBody User user) {
		//TODO: process PUT request
		
		return userService.login(user.);
	}

	@PutMapping("/users/logout/{id}")
	public User logout(@PathVariable String id) {
		//TODO: process PUT request
		
		return entity;
	}

}
