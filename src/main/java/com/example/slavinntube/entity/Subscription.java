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
    @Column(name ="subscriberToId")
    private UUID subscriberToId;

    public Subscription() {
    }

    public Subscription(UUID subscriberId, UUID subscriberToId) {
        this.subscriberId = subscriberId;
        this.subscriberToId = subscriberToId;
    }


    public UUID getSubscriberId() {
        return subscriberId;
    }

    public void setSubscriberId(UUID subscriberId) {
        this.subscriberId = subscriberId;
    }

    public UUID getSubscriberToId() {
        return subscriberToId;
    }

    public void setSubscriberToId(UUID subscriberToId) {
        this.subscriberToId = subscriberToId;
    }
}
