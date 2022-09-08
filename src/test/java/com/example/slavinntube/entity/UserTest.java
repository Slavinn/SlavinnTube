package com.example.slavinntube.entity;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class UserTest {
    User user;

    User userTwo;

    User userThree;
    UUID id;
    Date currentDate;
    Video newVideo;

    VideoLike newVideoLike;

    Subscription newSubscription;


    @BeforeEach
    public void userBeforeEach() {
        this.user =  new User("user1", "user1@gmail.com");
        this.userTwo = new User("userTwo","userTwo@gmail.com");
        this.userThree = new User("userThree","userThree@gmail.com");
        this.userTwo.setId(UUID.randomUUID());
        this.userThree.setId(UUID.randomUUID());

        this.currentDate = new Date();
        String videoUrl = "https://slavinntube.s3.us-west-2.amazonaws.com/SampleVideo_720x480_30mb.mp4";
        String thumbnailUrl = "https://slavinntube.s3.us-west-2.amazonaws.com/thumbnail-sample-30mbpng.png";
        this.newVideo = new Video("title", "description",videoUrl, thumbnailUrl, this.user.getId(), 200);
        this.newVideo.setId(UUID.randomUUID());
        this.newVideoLike = new VideoLike(1, this.user, this.newVideo);
        this.newSubscription = new Subscription();
    }


    @Test
    void idGetterSetterTest() {
        // test getter
        assertNull(this.user.getId(), "Id should be null");

        // test setter
        UUID newId = UUID.randomUUID();
        this.user.setId(newId);
        assertEquals(newId, this.user.getId(),"Id should return newly generated UUID");
        assertNotEquals(this.id, this.user.getId(), "Id should not return original UUID");
    }

    @Test
    void createdAtGetterSetterTest() {
        Date newDate = new Date();
        this.user.setCreatedAt(newDate);
        assertEquals(newDate, user.getCreatedAt(), "CreatedAt should return newly generated Date");
        assertNotEquals(currentDate, user.getCreatedAt(), "CreatedAt should not return original Date");
    }

    @Test
    void usernameGetterSetterTest() {
        user.setUsername("user2");
        assertEquals("user2", user.getUsername(), "Username should return newly generated Name");
        assertNotEquals("user1", user.getUsername(), "Username should not return original Name");
    }

    @Test
    void emailGetterSetterTest() {
        user.setEmail("user2@gmail.com");
        assertEquals("user2@gmail.com", user.getEmail(), "Email should return newly generated Email");
        assertNotEquals("user1@gmail.com", user.getEmail(), "Email should not return original Email");
    }

    @Test
    void avatarGetterSetterTest() {
        // test getter
        assertNull(user.getAvatar(), "Avatar should be null");

        // test setter
        String avatarUrl = "https://slavinntube.s3.us-west-2.amazonaws.com/testAvatarImage.png";
        this.user.setAvatar(avatarUrl);
        assertEquals(avatarUrl, this.user.getAvatar(), "Avatar should be return newly generated AvatarUrl");

    }

    @Test
    void coverGetterSetterTest() {
        // test getter
        assertNull(user.getCover(), "Cover should be null");

        // test setter
        String coverUrl = "https://slavinntube.s3.us-west-2.amazonaws.com/testCoverImage.jpg";
        this.user.setCover(coverUrl);
        assertEquals(coverUrl, this.user.getCover(),"Cover should return newly generated CoverUrl");
    }

    @Test
    void videosGetterSetterTest() {
        // test getter
        assertNull(this.user.getVideos(), "Videos should return null");

        // test setter
        List<Video> videoList = new ArrayList<>(List.of(this.newVideo));

        this.user.setVideos(videoList);
        assertArrayEquals(videoList.toArray(), this.user.getVideos().toArray(), "Videos should return the newly generated List<Video>");
    }

    @Test
    void videoLikesGetterSetterTest() {
        // test getter
        assertNull(this.newVideoLike.getId(), "VideoLike should return null");

        // test setter
        List<VideoLike> videoLikeList = new ArrayList<>(List.of(this.newVideoLike));
        this.user.setVideoLikes(videoLikeList);
        assertArrayEquals(videoLikeList.toArray(), this.user.getVideoLikes().toArray(), "VideoLike should return the newly generated List<VideoLike>");
    }

    @Test
    void subscribers() {
        // test getter

    }

    @Test
    void subscribedTo() {
        fail("This test has yet to be implemented");
    }
}