package com.example.slavinntube.entity;

import javax.persistence.*;

import java.util.UUID;

@Entity
@Table(name = "subscription")
public class Subscription {
    @Id
    @Column(name ="subscriberId")
    private UUID subscriberId;

    @Id
    @Column(name ="subscribedToId")
    private UUID subscribedToId;

    public Subscription() {
    }

    public Subscription(UUID subscriberId, UUID subscribedToId) {
        this.subscriberId = subscriberId;
        this.subscribedToId = subscribedToId;
    }


    public UUID getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(UUID subscriberId) {
        this.subscriberId = subscriberId;
    }

    public UUID getSubscribedToId() {
        return subscribedToId;
    }

    public void setSubscribedToId(UUID subscriberToId) {
        this.subscribedToId = subscriberToId;
    }
}
