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
    private User userId;

    @ManyToOne
    @JoinColumn(name ="videoId")
    private Video videoId;


    public VideoLike() {
    }

    public VideoLike(int like, User userId, Video videoId) {
        this.createdAt = new Date();
        this.like = like;
        this.userId = userId;
        this.videoId = videoId;
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

    public User getUserId() {
        return userId;
    }

    public void setUserId(User userId) {
        this.userId = userId;
    }

    public Video getVideoId() {
        return videoId;
    }

    public void setVideoId(Video videoId) {
        this.videoId = videoId;
    }
}
