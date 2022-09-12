package com.example.slavinntube.service;

import com.example.slavinntube.entity.User;
import com.example.slavinntube.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource("/application.properties")
@SpringBootTest
class UserServiceImplTest {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserService userService;
    private User userOne;

    @BeforeEach
    void setUp() {
        this.userOne = new User("username", "email@address.com");
    }

    @Test
    void findAll() {
        fail("Test not implemented");
    }

    @Test
    void getById() {
        fail("Test not implemented");
    }

    @Test
    void save() {

        userService.save(this.userOne);

        User getCreatedUser = userService.getById(this.userOne.getId());

        assertEquals(this.userOne.getId(), getCreatedUser.getId(), "get By Id");
    }

    @Test
    void update() {
        fail("Test not implemented");
    }

    @Test
    void deleteById() {
        fail("Test not implemented");
    }

    @AfterEach
    void takeDown() {
        userService.deleteById(this.userOne.getId());
    }
}