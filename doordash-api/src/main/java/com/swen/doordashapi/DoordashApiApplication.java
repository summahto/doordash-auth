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

	/**
	 * shoppingLists
	 * Holds the data for this shopping list application
	 * 
	 * shoppingLists : {
		* "User1": {
		* 		"List1": ["Item1", "Item2", "Item3"],
		* 		"List2": ["Item1", "Item2", "Item3"]
		* 		},
		* "User2": {
		* 		"List1": ["Item1", "Item2", "Item3"]
		* 		}
	 * }
	 */
	private Map<String, Map<String, List<String>>> shoppingLists = new HashMap();

	/**
	 * Adds an item to a shopping list
	 * @param user The name of the user who made the list
	 * @param list The name of the list that is getting addded to
	 * @param item The item that is getting added to the list
	 */
	@PostMapping("/{user}/add/{list}/{item}")
	public void addItemToShoppingList(@PathVariable String user, @PathVariable String list, @PathVariable String item) {
		shoppingLists.get(user).get(list).add(item);
	}
	/**
	 * Adds a new shopping list
	 * @param user The name of the user who made the list
	 * @param list The name of the new list
	 */
	@PostMapping("/{user}/add/{list}")
	public void addShoppingList(@PathVariable String user, @PathVariable String list) {
		shoppingLists.get(user).put(list, new ArrayList<String>());
	}
	/**
	 * Adds a new user
	 * @param user The name of the new user
	 */
	@PostMapping("/addUser/{user}")
	public void addUser(@PathVariable String user) {
		shoppingLists.put(user, new HashMap<>());
	}
	/**
	 * Gets all a single specifyed shopping list
	 * @param user The name of the user whos list we are retriving
	 * @param list The name of the list that is being retrived
	 * @return
	 */
	@GetMapping("/{user}/get/{list}")
	public List<String> getShoppingList(@PathVariable String user, @PathVariable String list) {
		return shoppingLists.get(user).get(list);
	}
	/**
	 * Gets all shopping lists of a specifyed users
	 * @param user The name of the user whos lists are being retrived
	 * @return
	 */
	@GetMapping("/{user}/get")
	public Map<String, List<String>> getAllUserShoppingLists(@PathVariable String user) {
		return shoppingLists.get(user);
	}
	/**
	 * Gets all shopping lists
	 * @return
	 */
	@GetMapping("/getAll")
	public Map<String, Map<String, List<String>>> getAllShoppingLists() {
		return shoppingLists;
	}
	/**
	 * Deletes a furfiled shoping list
	 * @param user The name of the user whoes list is done
	 * @param list The name of the list that is done
	 */
	@DeleteMapping("/{user}/finish/{list}")
	public void finishShoppingList(@PathVariable String user, @PathVariable String list) {
		shoppingLists.get(user).get(list).clear();
		//TODO: Tell the customer that a list is furfilled
	}
	public static void main(String[] args) {
		SpringApplication.run(DoordashApiApplication.class, args);
	}

}
