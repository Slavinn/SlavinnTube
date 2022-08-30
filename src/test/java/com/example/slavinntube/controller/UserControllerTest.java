package com.example.slavinntube.controller;

import com.example.slavinntube.SlavinnTubeApplication;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(classes = SlavinnTubeApplication.class,
        webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class UserControllerTest {

    @LocalServerPort
    private int port;

    @Autowired
    private TestRestTemplate restTemplate;

    @Sql({''})
    @Test
    void getAllUsers() {
    }

    @Test
    void createUser() {
    }

    @Test
    void updatedUser() {
    }

    @Test
    void deleteUser() {
    }
}