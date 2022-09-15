package com.example.slavinntube.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class CommentTest {

    Comment commentOne;

    UUID id;

    String text;

    User userId;

    Video videoId;

    @BeforeEach
    void setUp() {
        this.text = "First comment for video";
        this.userId = new User();
        this.userId.setId(UUID.randomUUID());

        this.videoId = new Video();
        this.videoId.setId(UUID.randomUUID());

        this.id = UUID.randomUUID();

        this.commentOne = new Comment(text,userId, videoId);
        this.commentOne.setId(this.id);
    }

    @Test
    void getId() {
        assertNotNull(this.commentOne.getId(), "commentOne Id should not be null");
        assertEquals(this.id, this.commentOne.getId(), "commentOne Id should be equal to set id");
    }

    @Test
    void setId() {
        UUID newId = UUID.randomUUID();

        this.commentOne.setId(newId);
        assertNotEquals(this.id, this.commentOne.getId(), "commentOne Id should not be equal to old id");
        assertEquals(newId, this.commentOne.getId(), "commentOne Id should be equal to newly set Id");
    }

    @Test
    void getCreatedAt() {
        assertNotNull(this.commentOne.getCreatedAt(), "Comment createdAt should not be bull");
    }

    @Test
    void setCreatedAt() {
        Date newDate = new Date();

        this.commentOne.setCreatedAt(newDate);
        assertEquals(newDate, this.commentOne.getCreatedAt(), "Comment createdAt should be set to newDate");
    }

    @Test
    void getText() {
        assertNotNull(this.commentOne.getText(), "Comment text should not be null");
        assertEquals(this.text, this.commentOne.getText(), "Comment text should bet set to this.text");
    }

    @Test
    void setText() {
        String newText = "Comment edited and changed";

        this.commentOne.setText(newText);

        assertNotEquals(this.text, this.commentOne.getText(),"Comment text should not be equal to this.text");
        assertEquals(newText, this.commentOne.getText(),"Comment text should be equal to newText");
    }

    @Test
    void getUserId() {
        assertNotNull(this.commentOne.getUser(), "userid should not be null");
        assertEquals(this.userId, this.commentOne.getUser(),  "userid should be set to this.userid");
    }

    @Test
    void setUserId() {
        User newUser = new User();
        newUser.setId(UUID.randomUUID());

        this.commentOne.setUser(newUser);

        assertNotEquals(this.userId, this.commentOne.getUser(),"userid should not be set to original id");
        assertEquals(newUser, this.commentOne.getUser(), "userid should be set to newUserId");
    }

    @Test
    void getVideoId() {
        assertNotNull(this.commentOne.getVideo(), "videoId should not be null");
        assertEquals(this.videoId, this.commentOne.getVideo(), "videoId should be set to original value declared in constructor");
    }

    @Test
    void setVideoId() {
        Video newVideo = new Video();
        newVideo.setId(UUID.randomUUID());

        this.commentOne.setVideo(newVideo);

        assertNotEquals(this.videoId.getId(), this.commentOne.getVideo().getId(), "videoId should not be set to original id");
        assertEquals(newVideo, this.commentOne.getVideo(), "videoId should be set to newVideoId");
    }
}