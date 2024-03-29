package com.example.slavinntube.entity;


import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name ="videoLike")
public class VideoLike {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Temporal(value= TemporalType.TIMESTAMP)
    @Column(name ="createdAt", updatable = false)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "like")
    private int like;

    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @ManyToOne
    @JoinColumn(name ="videoId")
    private Video video;


    public VideoLike() {
    }

    public VideoLike(int like, User user, Video video) {
        this.createdAt = new Date();
        this.like = like;
        this.user = user;
        this.video = video;
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

    public int getLike() {
        return like;
    }

    public void setLike(int like) {
        this.like = like;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User userId) {
        this.user = userId;
    }

    public Video getVideo() {
        return video;
    }

    public void setVideo(Video videoId) {
        this.video = videoId;
    }
}
