package com.swen.doordashapi.contoller;

import com.swen.doordashapi.model.LoginRequest;
import com.swen.doordashapi.model.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.swen.doordashapi.model.User;
import com.swen.doordashapi.service.UserService;

import java.util.List;
import java.util.logging.Logger;

@RestController
public class UserController {

	@Autowired
	private UserService userService;

	private static final Logger LOG = Logger.getLogger(UserController.class.getName());

	/* likely not necessary */
	@GetMapping
	public List<User> findAll() {
		return userService.findAll();
	}

	@GetMapping("/users/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id) {
		LOG.info("GET /users/" + id);

		try {
			User user = userService.findById(id).orElseThrow();
			return new ResponseEntity<>(user, HttpStatus.OK);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/users/{name}")
	public ResponseEntity<User> findByName(@PathVariable String name) {
		LOG.info("GET /users/" + name);

		try {
			User user = userService.findByName(name).orElseThrow();
			return new ResponseEntity<>(user, HttpStatus.OK);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping("/users")
	public ResponseEntity<User> create(@RequestBody User newUser) {
		LOG.info("POST /customer " + newUser);

		try{
			User savedUser = userService.save(newUser);
			return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
		}catch (Exception e){
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/users")
	public User update(@RequestBody User user) {
		return userService.save(user);
	}

	@PostMapping("/users/login")
	public ResponseEntity<Session> login(@RequestBody LoginRequest loginRequest) {
		try {
			Session session = userService.login(loginRequest.getName(), loginRequest.getPassword());
			return new ResponseEntity<>(session, HttpStatus.OK);
		} catch (RuntimeException e) {
			e.printStackTrace();
			return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
		}
	}


//	@PutMapping("/users/logout/{id}")
//	public User logout(@PathVariable String id) {
//		//TODO: process PUT request
//
//		return entity;
//	}

}
