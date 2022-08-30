package com.example.slavinntube.entity;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class VideoTest {
    UUID videoID = UUID.randomUUID();
    User tolkien = new User("J.R.R. Tolkien", "tolkien@gmail.com");
    String title = "The Lord of the Rings: The Fellowship of the Ring";
    String description = "A meek Hobbit from the Shire and eight companions set out on a journey to destroy the powerful One Ring and save Middle-earth from the Dark Lord Sauron.";
    String url = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.3f-HCiwnUnWOfgmz2lOHDAHaFa%26pid%3DApi&f=1";
    String thumbnail = "https://external-content.duckduckgo.com/iu/?u=https%3A%2F%2Ftse1.mm.bing.net%2Fth%3Fid%3DOIP.3f-HCiwnUnWOfgmz2lOHDAHaFa%26pid%3DApi&f=1";

    Video video = new Video(title, description,url,
            thumbnail, tolkien,2000);

    @Test
    void getUserId() {
        fail("This test has yet to be implemented");

    }

    @Test
    void getDescription() {
        assertEquals(description, video.getDescription());
    }

    @Test
    void getUrl() {
        assertEquals(url, video.getUrl());
    }

    @Test
    void getThumbnail() {
        assertEquals(thumbnail, video.getThumbnail());
    }

    @Test
    void getVideoLikes() {
        fail("This test has yet to be implemented");

    }

    @Test
    void getViews() {
        fail("This test has yet to be implemented");
    }

    @Test
    void setTitle() {
        String newTitle ="New video title";
        video.setTitle(newTitle);
        assertEquals(newTitle, video.getTitle());
    }

    @Test
    void setDescription() {
        String newDescription = "New video Description";
        video.setDescription(newDescription);
        assertEquals(newDescription, video.getDescription());
    }

    @Test
    void setUrl() {
        String newUrl = "https://videostreaming.com";
        video.setUrl(newUrl);
        assertEquals(newUrl, video.getUrl());
    }

    @Test
    void setThumbnail() {
        String newThumbnail = "https://thumbnail.com";
        video.setThumbnail(newThumbnail);
        assertEquals(newThumbnail, video.getThumbnail());
    }

    @Test
    void setUserId() {
        fail("This test has yet to be implemented");
    }

    @Test
    void setVideoLikes() {
        fail("This test has yet to be implemented");
    }

    @Test
    void setViews() {
        int newViews = 1000;
        video.setViews(newViews);
        assertEquals(newViews, video.getViews());
    }
}