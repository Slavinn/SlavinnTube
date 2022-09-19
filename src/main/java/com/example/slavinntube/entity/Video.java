package com.example.slavinntube.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "video")
public class Video {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name = "createdAt")
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "title")
    private String title;

    @Column(name = "description")
    private String description;

    @Column(name = "url")
    private String url;

    @Column(name = "thumbnail")
    private String thumbnail;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @OneToMany
    @Column(name = "videoLikes")
    private List<VideoLike> videoLikes;

    @OneToMany
    @Column(name = "views")
    private List<View> views;

    public Video() {
    }

    public Video(String title, String description, String url,
                 String thumbnail, User userId, List<VideoLike> videoLikes,
                 List<View> views) {
        this.createdAt = new Date();
        this.title = title;
        this.description = description;
        this.url = url;
        this.thumbnail = thumbnail;
        this.user = userId;
        this.videoLikes = videoLikes;
        this.views = views;
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }

    public List<VideoLike> getVideoLikes() {
        return videoLikes;
    }

    public void setVideoLikes(List<VideoLike> videoLikes) {
        this.videoLikes = videoLikes;
    }

    public List<View> getViews() {
        return views;
    }

    public void setViews(List<View> views) {
        this.views = views;
    }

    @Override
    public String toString() {
        return "Video{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", userId=" + user +
                ", videoLikes=" + videoLikes +
                ", views=" + views +
                '}';
    }
}
