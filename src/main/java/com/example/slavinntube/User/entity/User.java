package com.example.slavinntube.User.entity;

import com.example.slavinntube.Subscription.entity.Subscription;
import com.example.slavinntube.Video.entity.Video;

import java.util.Date;
import java.util.List;
import java.util.UUID;

public interface User {
    /**
     * get User id
     *
     * @return UUID id;
     */
    public UUID getId();

    /**
     * Set User id
     *
     * @param id UUID
     */
    public void setId(UUID id);

    /**
     * get createdAt
     *
     * @return createdAt Date
     */
    public Date getCreatedAt();

    /**
     * set createdAt
     *
     * @param createdAt Date
     */
    public void setCreatedAt(Date createdAt);

    /**
     * get userName
     *
     * @return userName String
     */
    public String getUsername();

    /**
     * set userName
     *
     * @param username
     */
    public void setUsername(String username);

    /**
     * get email
     *
     * @return email String
     */
    public String getEmail();

    /**
     * set email
     *
     * @param email String
     */
    public void setEmail(String email);

    /**
     * get avatar
     *
     *  @return avatar String
     */
    public String getAvatar();

    /**
     * set avatar
     *
     * @param avatar String
     */
    public void setAvatar(String avatar);

    /**
     * get cover
     *
     * @return cover String
     */
    public String getCover();

    /**
     * set cover
     *
     * @param cover String
     */
    public void setCover(String cover);

    /**
     * get list of video
     *
     * @return List<Video>
     */
    public List<Video> getVideos();

    /**
     * set list of videos
     *
     * @param videos List<Video>
     */
    public void setVideos(List<Video> videos);

    /**
     * get list of subscribers
     *
     * @return List<Subscription>
     */
    public List<Subscription> getSubscribers();

    /**
     * set list of subscribers
     *
     * @param subscribers List<Subscription>
     */
    public void setSubscribers(List<Subscription> subscribers);

    /**
     * get Subscriptions
     *
     * @return List<Subscription>
     */
    public List<Subscription> getSubscribed();

    /**
     * set list of subscription
     *
     * @param subscribed List<Subscription>
     */
    public void setSubscribed(List<Subscription> subscribed);


    }
