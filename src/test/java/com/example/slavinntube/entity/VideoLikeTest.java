package com.example.slavinntube.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class VideoLikeTest {
    UUID id;
    int like;
    User user;
    Video video;
    VideoLike videoLikeOne;

    Date createdAt;


    @BeforeEach
    void setUp() {
        this.id = UUID.randomUUID();
        this.like = 1;
        this.createdAt = new Date();
        this.user = new User();
        user.setId(UUID.randomUUID());

        this.video = new Video();
        this.video.setId(UUID.randomUUID());

        this.videoLikeOne = new VideoLike(this.like, this.user, this.video);
        this.videoLikeOne.setId(this.id);

        this.videoLikeOne.setCreatedAt(this.createdAt);
    }

    @Test
    void getId() {
        assertNotNull(this.videoLikeOne.getId(), "VideoLike id should be null");
        assertEquals(this.id, this.videoLikeOne.getId(), "Videolike id should be set to this.id");
    }

    @Test
    void setId() {
        UUID newUuid = UUID.randomUUID();
        this.videoLikeOne.setId(newUuid);
        assertEquals(newUuid, this.videoLikeOne.getId(), "videoLike id should be set to newUuid");
        assertNotEquals(this.id, this.videoLikeOne.getId(),"videoLike id should not be equal to old id");
    }

    @Test
    void getCreatedAt() {
        assertEquals(this.createdAt, this.videoLikeOne.getCreatedAt(), "videoLike should be equal to this.createdAt");
    }


    @Test
    void setCreatedAt() {
        Date newCreatedAt = new Date();
        this.videoLikeOne.setCreatedAt(newCreatedAt);
        assertEquals(newCreatedAt, this.videoLikeOne.getCreatedAt(), "createdAt should be set to newCreatedAt date");
    }

    @Test
    void getLike() {
    }

    @Test
    void setLike() {
    }

    @Test
    void getUserId() {
    }

    @Test
    void setUserId() {
    }

    @Test
    void getVideoId() {
    }

    @Test
    void setVideoId() {
    }
}