package com.example.slavinntube.entity;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "user")
public class User {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @Temporal(value = TemporalType.TIMESTAMP)
    @Column(name= "createdAt", updatable=false)
    @CreationTimestamp
    private Date createdAt;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @Lob
    @Column(name = "avatar", columnDefinition = "BLOB")
    private byte[] avatar;

    @Lob
    @Column(name = "cover", columnDefinition = "BLOB")
    private byte[]  cover;

    @OneToMany
    @JoinColumn(name = "userId")
    private List<Video> videos;

    @OneToMany
    @JoinColumn(name = "userId")
    private List<VideoLike> videoLikes;


//    @ManyToMany
//    @JoinColumn(name ="subscriberId")
//    private List<Subscription> subscribers;
//
//    @ManyToMany
//    @JoinColumn(name = "subscribedTo")
//    private  List<Subscription> subscribedTo;

    public User() {
    }

    public User(String username, String email
//            , byte[] avatar, byte[] cover
//            ,List<Video> videos, List<VideoLike> videoLikes, List<Subscription> subscribers, List<Subscription> subscribedTo
    ) {
        this.createdAt = new Date();
        this.username = username;
        this.email = email;
//        this.avatar = avatar;
//        this.cover = cover;
//        this.videos = videos;
//        this.videoLikes = videoLikes
//        this.subscribers = subscribers;
//        this.subscribedTo = subscribedTo;
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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public byte[] getAvatar() {
        return avatar;
    }

    public void setAvatar(byte[] avatar) {
        this.avatar = avatar;
    }

    public byte[] getCover() {
        return cover;
    }

    public void setCover(byte[] cover) {
        this.cover = cover;
    }

    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }

    public List<VideoLike> getVideoLikes() {
        return videoLikes;
    }

    public void setVideoLikes(List<VideoLike> videoLikes) {
        this.videoLikes = videoLikes;
    }

    //
//    public List<Subscription> getSubscribers() {
//        return subscribers;
//    }
//
//    public void setSubscribers(List<Subscription> subscribers) {
//        this.subscribers = subscribers;
//    }
//
//    public List<Subscription> getSubscribedTo() {
//        return subscribedTo;
//    }
//
//    public void setSubscribedTo(List<Subscription> subscribedTo) {
//        this.subscribedTo = subscribedTo;
//    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", createdAt=" + createdAt +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", avatar=" + Arrays.toString(avatar) +
                ", cover=" + Arrays.toString(cover) +
//                ", videos=" + videos +
//                ", subscribers=" + subscribers +
//                ", subscribedTo=" + subscribedTo +
                '}';
    }
}
