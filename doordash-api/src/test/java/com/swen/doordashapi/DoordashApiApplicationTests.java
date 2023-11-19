package com.swen.doordashapi;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class DoordashApiApplicationTests {

	@Autowired
    private TestRestTemplate restTemplate;

    @Test
    public void testAddUser() {
        ResponseEntity<String> response = restTemplate.postForEntity("/addUser/john", null, String.class);
        System.out.println(response);
    }

    @Test
    public void testAddShoppingList() {
        ResponseEntity<String> response = restTemplate.postForEntity("/john/add/groceries", null, String.class);
        System.out.println(response);
    }

    @Test
    public void testAddItemToShoppingList() {
        ResponseEntity<String> response = restTemplate.postForEntity("/john/add/groceries/milk", null, String.class);
        System.out.println(response);
    }

    @Test
    public void testGetShoppingList() {
        ResponseEntity<String> response = restTemplate.getForEntity("/john/get/groceries", String.class);
        System.out.println(response);
    }

    @Test
    public void testGetAllUserShoppingLists() {
        ResponseEntity<String> response = restTemplate.getForEntity("/john/get", String.class);
        System.out.println(response);
    }

    @Test
    public void testGetAllShoppingLists() {
        ResponseEntity<String> response = restTemplate.getForEntity("/getAll", String.class);
		System.out.println(response);
    }

    @Test
    public void testFinishShoppingList() {
        ResponseEntity<String> response = restTemplate.exchange("/john/finish/groceries", null, null, String.class);
		System.out.println(response);
    }

}
