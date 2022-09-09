package com.example.slavinntube.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class ViewTest {
    UUID id;

    View view;
    User userOne;
    Video videoOne;

    @BeforeEach
    void setUp() {
        this.userOne = new User();
        this.userOne.setId(UUID.randomUUID());

        this.videoOne = new Video();
        this.videoOne.setId(UUID.randomUUID());

        this.id = UUID.randomUUID();

        this.view = new View(this.userOne, this.videoOne);
        this.view.setId(this.id);

    }

    @Test
    void getId() {
        assertNotNull(this.view.getId(),"view id should not be null");
        assertEquals(this.id, this.view.getId(),"view id should be set the this.id");
    }

    @Test
    void setId() {
        UUID newUuid = UUID.randomUUID();

        this.view.setId(newUuid);

        assertNotEquals(this.id, this.view.getId(),"view id should  not be equal to this.id");
        assertEquals(newUuid, this.view.getId(), "view id should be equal to newUuid");
    }

    @Test
    void getCreatedAt() {
        assertNotNull(this.view.getCreatedAt(), "should not be null");
    }

    @Test
    void setCreatedAt() {
        Date newDate = new Date();

        this.view.setCreatedAt(newDate);

        assertEquals(newDate, this.view.getCreatedAt(), "createdAt should be set to newDate");
    }

    @Test
    void getUserId() {
        assertNotNull(this.view.getUserId().getId(), "userid should not be null");
        assertEquals(this.userOne, this.view.getUserId(), "view user should be equal to userOne");
    }

    @Test
    void setUserId() {
        User newUser = new User();
        newUser.setId(UUID.randomUUID());

        this.view.setUserId(newUser);

        assertNotEquals(this.userOne, this.view.getUserId(), "view get user should be not be equal to userOne");
        assertEquals(newUser, this.view.getUserId(), "view get user should be equal to newUser");
    }

    @Test
    void getVideoId() {
        assertNotNull(this.view.getVideoId(), "Video id should not be null");
        assertEquals(this.userOne, this.view.getUserId(), "view video should be equal to videoOne");
    }

    @Test
    void setVideoId() {
        Video newVideo = new Video();
        newVideo.setId(UUID.randomUUID());

        this.view.setVideoId(newVideo);

        assertNotEquals(this.videoOne,this.view.getVideoId(),"view get video should be not be equal to videoOne");
        assertEquals(newVideo,this.view.getVideoId(),"view get video should be equal to newVideo");
    }
}