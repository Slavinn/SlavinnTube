package com.example.slavinntube.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class VideoTest {

    User userOne;

    Video videoOne;
    String title = "SampleVideo_720x480_30mb.mp4";
    String description = "free video found online with forest animated animals";
    String url = "https://slavinntube.s3.us-west-2.amazonaws.com/SampleVideo_720x480_30mb.mp4";
    String thumbnail = "https://slavinntube.s3.us-west-2.amazonaws.com/thumbnail-sample-30mbpng.png";


    VideoLike videoLikeOne;

    View view;


    @BeforeEach
    void setUp() {
        // create user test object
        this.userOne = new User();
        this.userOne.setId(UUID.randomUUID());

        // create video test object
        this.videoOne = new Video(
                this.title,
                this.description,
                this.url,
                this.thumbnail,
                this.userOne,
                new ArrayList<VideoLike>(),
                new ArrayList<View>()
        );

        // create videolikes test object
        this.videoLikeOne = new VideoLike(1,this.userOne,this.videoOne);

        // create view test object
        this.view = new View(this.userOne, this.videoOne);

        // add videoLike object to video videoLikeList
        this.videoOne.setVideoLikes(new ArrayList<>(List.of(this.videoLikeOne)));

        // add view object to video viewList
        this.videoOne.setViews(new ArrayList<>(List.of(this.view)));

    }
    @Test
    void getUserId() {
        assertNotNull(this.videoOne.getUser(), "videOne user object should not be Null");
        assertNotNull(this.videoOne.getUser().getId(), "videOne user ID should not be Null");
        assertEquals(this.userOne, this.videoOne.getUser(), "videOne user should equal userOne");
        assertEquals(this.userOne.getId(), this.videoOne.getUser().getId(), "videoOne user id should equal userOne ID");
    }

    @Test
    void getDescription() {
        assertNotNull(this.videoOne.getDescription(), "videoOne description should not be null");
        assertEquals(this.description, this.videoOne
                .getDescription(), "videoOne description should equal, description string of constructor");
    }

    @Test
    void getUrl() {
        assertNotNull(this.videoOne.getUrl(), "videoOne url should not be null");
        assertEquals(this.url,
                this.videoOne
                .getUrl(), "videoOne url should equal url string of constructor");
    }

    @Test
    void getThumbnail() {
        assertNotNull(this.videoOne.getThumbnail(), "videoOne Thumbnail should not be null");
        assertEquals(this.thumbnail, this.videoOne.getThumbnail(),
                "videoOne Thumbnail should equal Thumbnail string of constructor");
    }

    @Test
    void getVideoLikes() {
        assertNotNull(this.videoOne.getVideoLikes(), "videoOne videLike List should not be null");
       assertArrayEquals(new ArrayList<>(List.of(this.videoLikeOne)).toArray() ,this.videoOne.getVideoLikes().toArray(),
               "videoOne videoLike List should equal List of this.videolike object");

    }

    @Test
    void getViews() {
        assertNotNull(this.videoOne.getViews(), "videoOne views List should not be null");
        assertArrayEquals(new ArrayList<>(List.of(this.view)).toArray(), this.videoOne.getViews().toArray(),
                "videoOne view List should equal List of this.view object");
    }

    @Test
    void setTitle() {
        assertNotNull(this.videoOne.getTitle(), "videoOne title should not be null");
        String newTitle = "new title test";
        this.videoOne.setTitle(newTitle);
        assertEquals(newTitle, this.videoOne.getTitle(), "title should equal new title set");
        assertNotEquals(this.title, this.videoOne.getTitle(), "title should not equal old title set");

    }

    @Test
    void setDescription() {
        assertNotNull(this.videoOne.getDescription(), "description should not be null");
        String newDescription = "new description for video";
        this.videoOne.setDescription(newDescription);
        assertEquals(newDescription, this.videoOne.getDescription(), "Description should equal new Description set");
        assertNotEquals(this.description, this.videoOne.getDescription(), "Description should not equal old description set");
    }

    @Test
    void setUrl() {
        assertNotNull(this.videoOne.getUrl(), "url should not be null");
        String newUrl = "new videoURL";
        this.videoOne.setUrl(newUrl);
        assertEquals(newUrl, this.videoOne.getUrl(), "url should equal new url set");
        assertNotEquals(this.url, this.videoOne.getUrl(), "url should not equal old  set");

    }

    @Test
    void setThumbnail() {
        assertNotNull(this.videoOne.getThumbnail(), "thumbnail should not be null");
        String newThumbnail = "new thumbnailurl";
        this.videoOne.setThumbnail(newThumbnail);
        assertEquals(newThumbnail, this.videoOne.getThumbnail(), "thumbnail should equal new thumbnail set");
        assertNotEquals(this.title, this.videoOne.getThumbnail(), "thumbnail should not equal old thumbnail set");

    }

    @Test
    void setUserId() {
        assertNotNull(this.videoOne.getUser().getId(), "video one user id should not be null");
        UUID newUUID = UUID.randomUUID();
        this.videoOne.getUser().setId(newUUID);
        assertEquals(newUUID, this.videoOne.getUser().getId(), "videoOne user id should be equal to new id set");
        assertNotEquals(this.videoOne.getUser().getId(), "videoOne user id should not equal old id set");

    }

    @Test
    void setVideoLikes() {
        assertNotNull(this.videoOne.getVideoLikes(), "videoLikes list should not be null");

        User newUser = new User();
        newUser.setId(UUID.randomUUID());

        Video newVideo = new Video();
        newVideo.setId(UUID.randomUUID());

        VideoLike newVideoLikeOne = new VideoLike(1,newUser, newVideo);

        List<VideoLike> videoLikeList = this.videoOne.getVideoLikes();
        videoLikeList.add(newVideoLikeOne);

        this.videoOne.setVideoLikes(videoLikeList);

        assertArrayEquals(videoLikeList.toArray(), this.videoOne.getVideoLikes().toArray(),
                "videoLikes List should be equal to newly set List");
    }

    @Test
    void setViews() {
        assertNotNull(this.videoOne.getViews(), "views list should not be null");

        User newUser = new User();
        newUser.setId(UUID.randomUUID());

        Video newVideo = new Video();
        newVideo.setId(UUID.randomUUID());

        View newView = new View(newUser, newVideo);

        List<View> newViewList = this.videoOne.getViews();
        newViewList.add(newView);

        this.videoOne.setViews(newViewList);

        assertArrayEquals(newViewList.toArray(), this.videoOne.getViews().toArray(),
                "viewsList should be equal to newly set List");
    }
}