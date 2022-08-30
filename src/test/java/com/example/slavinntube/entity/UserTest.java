package com.example.slavinntube.entity;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user = new User("user1", "user1@gmail.com");
    Date currentDate = new Date();

    @Test
    void getId() {
        fail("This test has yet to be implemented");
    }

    @Test
    void setId() {
        fail("This test has yet to be implemented");

    }

    @Test
    void getCreatedAt() {
        assertEquals(currentDate, user.getCreatedAt());
    }

    @Test
    void setCreatedAt() {
        Date newDate = new Date();
        user.setCreatedAt(newDate);
        assertEquals(newDate, user.getCreatedAt());

    }

    @Test
    void getUsername() {
        assertEquals("user1", user.getUsername());
    }

    @Test
    void setUsername() {
        user.setUsername("user2");
        assertEquals("user2", user.getUsername());
    }

    @Test
    void getEmail() {
        user.setEmail("user1@gmail.com");
        assertEquals("user1@gmail.com", user.getEmail());
    }

    @Test
    void setEmail() {
        user.setEmail("user1@gmail.com");
        assertEquals("user1@gmail.com", user.getEmail());
    }

    @Test
    void getAvatar() {
        fail("This test has yet to be implemented");

    }

    @Test
    void setAvatar() {
        fail("This test has yet to be implemented");

    }

    @Test
    void getCover() {
        fail("This test has yet to be implemented");

    }

    @Test
    void setCover() {
        fail("This test has yet to be implemented");

    }

    @Test
    void getVideos() {
        fail("This test has yet to be implemented");

    }

    @Test
    void setVideos() {
        fail("This test has yet to be implemented");

    }

    @Test
    void getVideoLikes() {
        fail("This test has yet to be implemented");

    }

    @Test
    void setVideoLikes() {
        fail("This test has yet to be implemented");

    }
}