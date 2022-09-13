package com.example.slavinntube.service;

import com.example.slavinntube.entity.User;
import com.example.slavinntube.repository.UserRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.TestPropertySource;

import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;

//@TestPropertySource("/application.properties")
@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;
    @InjectMocks
    private UserServiceImpl userService;
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
        given(userRepository.save(userOne)).willReturn(userOne);
    }

    @Test
    void update() {
        fail("Test not implemented");
    }

    @Test
    void deleteById() {
        fail("Test not implemented");
    }
}