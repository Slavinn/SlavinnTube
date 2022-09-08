package com.example.slavinntube.controller;

import com.example.slavinntube.repository.UserRepository;
import com.example.slavinntube.service.UserService;
import org.json.JSONException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.*;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = UserController.class)
public class UserControllerTest {


    @Autowired
    private UserService userService;

    @MockBean
    private UserRepository userRepository;
    @Autowired
    private MockMvc mockMvc;


    @Test
    void getAllUsers() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders
                .get("/api/v1/users")
                .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isOk());


//        UserList responseEntity = this.restTemplate
//                .getForObject("http://localhost:" + port + "/api/v1/users", UserList.class);
//        List<User> userList = responseEntity.getUserList();
//        assertTrue(userList.size() == 3);
    }

//    @Sql({"classpath:slavinnTube.sql", "classpath:data.sql"})
    @Test
    void createUser() throws JSONException {
//        User newUser = new User("user4", "user4@gmail.com");
//        HttpHeaders header = new HttpHeaders();
//        header.setContentType(MediaType.APPLICATION_JSON);
//        HttpEntity<User> request = new HttpEntity<>(newUser, header);
//
//
//        ResponseEntity responseEntity = this.restTemplate
//                .postForEntity("http://localhost:" + port + "/api/v1/users", request, User.class);
//        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
    }

    @Test
    void updatedUser() {
    }

    @Test
    void deleteUser() {
    }
}