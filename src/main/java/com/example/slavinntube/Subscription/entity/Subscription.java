package com.example.slavinntube.Subscription.entity;

import com.example.slavinntube.User.entity.Impl.UserImpl;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

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
    private UserImpl subscriber;

    @ManyToOne
    @JoinColumn(name ="subscribed")
    private UserImpl subscribedTo;

    public Subscription() {
    }

    public Subscription(UserImpl subscriber, UserImpl subscribedTo) {
        this.subscriber = subscriber;
        this.subscribedTo = subscribedTo;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UserImpl getSubscriber() {
        return subscriber;
    }

    public void setSubscriber(UserImpl subscriber) {
        this.subscriber = subscriber;
    }

    public UserImpl getSubscribedTo() {
        return subscribedTo;
    }

    public void setSubscribedTo(UserImpl subscriberTo) {
        this.subscribedTo = subscriberTo;
    }
}
