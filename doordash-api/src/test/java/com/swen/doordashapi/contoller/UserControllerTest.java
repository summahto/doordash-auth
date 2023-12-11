package com.swen.doordashapi.contoller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.swen.doordashapi.model.Session;
import com.swen.doordashapi.model.User;
import com.swen.doordashapi.model.UserTypes;
import com.swen.doordashapi.repository.SessionRepository;
import com.swen.doordashapi.repository.UserRepository;
import com.swen.doordashapi.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.MediaType;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@AutoConfigureMockMvc
class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserService userService;

    @Autowired
    private SessionRepository sessionRepository;

    @Autowired
    private ObjectMapper objectMapper;


    @Test
    void testLoginAndSessionId() throws Exception {

        User user = new User(null, "testUser", "testPassword", UserTypes.USER);
        userRepository.save(user);

        System.out.println("user id" + user.getId());

        String loginBody = "{\"name\":\"testUser\", \"password\":\"testPassword\"}";
        MvcResult result = mockMvc.perform(MockMvcRequestBuilders.post("/users/login")
                        .content(loginBody)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andReturn();

        String responseBody = result.getResponse().getContentAsString();
        Session loggedInSession = objectMapper.readValue(responseBody, Session.class);

        String sessionId = loggedInSession.getSessionID();
        assertTrue(sessionId.matches("^[a-f0-9]{8}-[a-f0-9]{4}-4[a-f0-9]{3}-[89aAbB][a-f0-9]{3}-[a-f0-9]{12}$"));
    }

    @Test
    void findByName() throws Exception {

        User user = userService.findByName("sumit").orElseThrow();
        assertFalse(user == null, "User not found for the specified name");
        String password = user.getPassword();
        System.out.println("Password for user sumit : " + password);
        assertFalse(password.matches("^[a-zA-Z]+$"), "Password should not contain only alphabets");

    }

}