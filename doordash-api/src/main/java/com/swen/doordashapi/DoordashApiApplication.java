package com.swen.doordashapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
public class DoordashApiApplication {

	private Map<String, Map<String, List<String>>> shoppingLists = new HashMap();

	@PostMapping("/{user}/add/{list}/{item}")
	public void addItemToShoppingList(@PathVariable String user, @PathVariable String list, @PathVariable String item) {
		shoppingLists.get(user).get(list).add(item);
	}
	@PostMapping("/{user}/add/{list}")
	public void addShoppingList(@PathVariable String user, @PathVariable String list) {
		shoppingLists.get(user).put(list, new ArrayList<String>());
	}
	@PostMapping("/addUser/{user}")
	public void addUser(@PathVariable String user) {
		shoppingLists.put(user, new HashMap<>());
	}
	@GetMapping("/{user}/get/{list}")
	public List<String> getShoppingList(@PathVariable String user, @PathVariable String list) {
		return shoppingLists.get(user).get(list);
	}
	@GetMapping("/{user}/get")
	public Map<String, List<String>> getAllUserShoppingLists(@PathVariable String user) {
		return shoppingLists.get(user);
	}
	@GetMapping("/getAll")
	public Map<String, Map<String, List<String>>> getAllShoppingLists() {
		return shoppingLists;
	}
	@DeleteMapping("/{user}/finish/{list}")
	public void finishShoppingList(@PathVariable String user, @PathVariable String list) {
		shoppingLists.get(user).get(list).clear();
		//TODO: Tell the customer that a list is furfilled
	}
	public static void main(String[] args) {
		SpringApplication.run(DoordashApiApplication.class, args);
	}

}
