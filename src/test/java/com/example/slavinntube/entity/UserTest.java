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
    public void setUp() {
        this.user =  new User("user1", "user1@gmail.com");
        this.userTwo = new User("userTwo","userTwo@gmail.com");
        this.userThree = new User("userThree","userThree@gmail.com");
        this.userTwo.setId(UUID.randomUUID());
        this.userThree.setId(UUID.randomUUID());

        this.currentDate = new Date();
        String videoUrl = "https://slavinntube.s3.us-west-2.amazonaws.com/SampleVideo_720x480_30mb.mp4";
        String thumbnailUrl = "https://slavinntube.s3.us-west-2.amazonaws.com/thumbnail-sample-30mbpng.png";
        this.newVideo = new Video("title", "description",videoUrl, thumbnailUrl, this.user, new ArrayList<VideoLike>(), new ArrayList<View>());
        this.newVideo.setId(UUID.randomUUID());
        this.newVideoLike = new VideoLike(1, this.user, this.newVideo);
        this.newSubscription = new Subscription();
        this.newSubscription.setSubscriber(this.userTwo);
        this.newSubscription.setSubscribedTo(this.userThree);
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
    }

    @Test
    void usernameGetterSetterTest() {
        user.setUsername("user2");
        assertNotEquals("user1", user.getUsername(), "Username should not return original Name");
        assertEquals("user2", user.getUsername(), "Username should return newly generated Name");
    }

    @Test
    void emailGetterSetterTest() {
        user.setEmail("user2@gmail.com");
        assertNotEquals("user1@gmail.com", user.getEmail(), "Email should not return original Email");
        assertEquals("user2@gmail.com", user.getEmail(), "Email should return newly generated Email");
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
        assertNull(this.userThree.getSubscribers(), "userThree Subscribers List should be null");

        // test setters
        List<Subscription> subscriptionList = new ArrayList<>(List.of(this.newSubscription));
        this.userThree.setSubscribers(subscriptionList);
        assertNotEquals(this.userThree, this.userThree.getSubscribers().get(0).getSubscriber(),"the subscriber ID in the arraylist index 0 should not be userThree ID");

        assertEquals(this.userTwo, this.userThree.getSubscribers().get(0).getSubscriber(),"the subscriber ID in the arraylist index 0 should be userTwo ID");
    }

    @Test
    void subscribedTo() {
        // test getter
        assertNull(this.userThree.getSubscribers(), "userTwo subscribedTo List should be null");

        // test setters
        List<Subscription> subscriptionList = new ArrayList<>(List.of(this.newSubscription));
        this.userTwo.setSubscribers(subscriptionList);
        assertNotEquals(this.userTwo, this.userTwo.getSubscribers().get(0).getSubscribedTo(), "the subscribedTo ID in arraylist index 0 should not be userTwo ID");

        assertEquals(this.userThree, this.userTwo.getSubscribers().get(0).getSubscribedTo(),"the subscribedTo ID in arraylist index 0 should be userThrees ID");

    }
}