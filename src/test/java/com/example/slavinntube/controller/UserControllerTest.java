package com.example.slavinntube.controller;

import com.example.slavinntube.repository.UserRepository;
import com.example.slavinntube.service.UserService;
import com.example.slavinntube.service.UserServiceImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import static org.junit.jupiter.api.Assertions.*;


@TestPropertySource("/application-test.properties")
@AutoConfigureMockMvc
@SpringBootTest
@Transactional
class UserControllerTest {

    private static MockHttpServletRequest request;

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Mock
    UserServiceImpl userService;

    @Autowired
    UserRepository userRepository;

    @Value("${sql.script.create.users}")
    private String sqlAddUsers;

    @Value("${sql.script.delete.users}")
    private String sqlDeleteUsers;


    @BeforeEach
    void setUp() {
        jdbcTemplate.execute(sqlAddUsers);
    }

    @AfterEach
    void tearDown() {
        jdbcTemplate.execute(sqlDeleteUsers);
    }

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

    @Test
    void handleException() {
    }

    @Test
    void testHandleException() {
    }

    @Test
    void testHandleException1() {
    }
}