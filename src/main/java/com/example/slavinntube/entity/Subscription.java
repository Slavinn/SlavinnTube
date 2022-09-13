package com.example.slavinntube.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "subscription")
public class Subscription {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(
            name = "UUID",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    @Column(name = "id", updatable = false, nullable = false)
    private UUID id;

    @ManyToOne
    @JoinColumn(name ="subscriber")
    private User subscriber;

    @ManyToOne
    @JoinColumn(name ="subscribed")
    private User subscribedTo;

    public Subscription() {
    }

    public Subscription(User subscriber, User subscribedTo) {
        this.subscriber = subscriber;
        this.subscribedTo = subscribedTo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public User getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(User subscriber) {
        this.subscriber = subscriber;
    }

    public User getSubscribedTo() {
        return subscribedTo;
    }

    public void setSubscribedTo(User subscriberTo) {
        this.subscribedTo = subscriberTo;
    }
}
