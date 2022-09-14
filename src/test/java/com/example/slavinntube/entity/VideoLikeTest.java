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
        assertNotNull(this.videoLikeOne.getLike(), "Like should not be null");
        assertEquals(this.like, this.videoLikeOne.getLike(), "like should be equal to this.like");
    }

    @Test
    void setLike() {
        int newLike = 2;
        this.videoLikeOne.setLike(newLike);
        assertEquals(newLike, this.videoLikeOne.getLike(), "Like should be equal to newLike set value");
    }

    @Test
    void getUserId() {
        assertNotNull(this.videoLikeOne.getUser(),"UserId should not be null");
        assertEquals(this.user, this.videoLikeOne.getUser(), " user should equal this.user");
    }

    @Test
    void setUserId() {
        User newUser = new User();
        newUser.setId(UUID.randomUUID());
        this.videoLikeOne.setUser(newUser);
        assertNotEquals(this.user, this.videoLikeOne.getUser(), "user should not be set to the original user value");
        assertEquals(newUser, this.videoLikeOne.getUser(),"user should be set to the newUser value");
    }

    @Test
    void getVideoId() {
        assertNotNull(this.videoLikeOne.getVideo(),"VideoID should not be null");
        assertEquals(this.video, this.videoLikeOne.getVideo(), "VideoId should equal this.video");
    }

    @Test
    void setVideoId() {
        Video newVideo = new Video();
        newVideo.setId(UUID.randomUUID());
        this.videoLikeOne.setVideo(newVideo);
        assertNotEquals(this.video, this.videoLikeOne.getVideo(), "video should not be set to the original video value");
        assertEquals(newVideo, this.videoLikeOne.getVideo(), "video should be set the newVideo value");
    }
}