package com.example.slavinntube.User.controller;

import com.example.slavinntube.User.entity.Impl.UserImpl;
import com.example.slavinntube.User.repository.UserRepository;
import com.example.slavinntube.User.service.Impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@TestPropertySource("/application-test.properties")
@AutoConfigureMockMvc
@SpringBootTest
//@Transactional
class UserImplControllerTest {

    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

//    @Autowired
//    private User user;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserRepository userRepository;

    @Value("${sql.script.create.users}")
    private String sqlAddUsers;

    @Value("${sql.script.delete.users}")
    private String sqlDeleteUsers;

    // media type for response body

    public static final MediaType APPLICATION_JSON_UTF8 = MediaType.APPLICATION_JSON;

    @BeforeAll
    public static void setup() {
        MockHttpServletRequest request = new MockHttpServletRequest();

        request.setParameter("username", "testUser");
        request.setParameter("email", "newTestEmail@mail.com");
    }

    @BeforeEach
    void setUpDatabase() {
        jdbc.execute(sqlAddUsers);
    }

    @AfterEach
    void tearDown() {
        jdbc.execute(sqlDeleteUsers);
    }

    @Test
    void getAllUsersHttpRequest() throws Exception {

        mockMvc.perform(MockMvcRequestBuilders.get("/api/v1/users"))
                .andExpect(status().isOk())
                .andExpect(content().contentType(APPLICATION_JSON_UTF8))
                .andExpect(jsonPath("$", hasSize(3)));

    }

    @Test
    void createUser() throws Exception{
        UserImpl createUser = new UserImpl("testUser", "newUserEmail@gmail.com");

        // How to parse a linkedhashmap from responseentity

        mockMvc.perform(post("/api/v1/users")
                .contentType(APPLICATION_JSON_UTF8)
                .content(objectMapper.writeValueAsString(createUser)))
                .andExpect(status().isCreated());
//                .andExpect(jsonPath("$", );

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