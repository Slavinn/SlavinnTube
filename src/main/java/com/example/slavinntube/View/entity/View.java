package com.example.slavinntube.View.entity;


import com.example.slavinntube.User.entity.Impl.UserImpl;
import com.example.slavinntube.Video.entity.Video;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "view")
public class View {

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

    @ManyToOne
    @JoinColumn(name ="userId")
    private UserImpl userId;


    @ManyToOne
    @JoinColumn(name ="videoId")
    private Video videoId;


    public View() {
    }

    public View(UserImpl userId, Video videoId) {
        this.createdAt = new Date();
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

    public UserImpl getUserId() {
        return userId;
    }

    public void setUserId(UserImpl userId) {
        this.userId = userId;
    }

    public Video getVideoId() {
        return videoId;
    }

    public void setVideoId(Video videoId) {
        this.videoId = videoId;
    }

    @Override
    public String toString() {
        return "View{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", userId=" + userId +
                ", videoId=" + videoId +
                '}';
    }
}
