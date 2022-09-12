package com.example.slavinntube.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SubscriptionTest {

    User subscriber;
    User subscribedTo;

    Subscription subscriptionOne;

    @BeforeEach
    void setUp() {
        this.subscriber = new User();
        this.subscriber.setId(UUID.randomUUID());
        this.subscribedTo = new User();
        this.subscribedTo.setId(UUID.randomUUID());

        this.subscriptionOne = new Subscription();

        this.subscriptionOne.setSubscriber(this.subscriber);
        this.subscriptionOne.setSubscribedTo(this.subscribedTo);
    }

    @Test
    void getSubscriberId() {
        assertNotNull(this.subscriptionOne.getSubscriber(), "subscriberId should not be null");
        assertEquals(this.subscriber, this.subscriptionOne.getSubscriber(), "subscriptionOne id should be set to subscriberId");
    }

    @Test
    void setSubscriberId() {
        User newSubscriber = new User();
        newSubscriber.setId(UUID.randomUUID());

        this.subscriptionOne.setSubscriber(newSubscriber);

        assertNotEquals(this.subscriber, this.subscriptionOne.getSubscriber(), "subscriptionOne subscriberId should not be set to old id");
        assertEquals(newSubscriber, this.subscriptionOne.getSubscriber(), "subscriptionOne subscriberId should be set to newSubscriberId");
    }

    @Test
    void getSubscriberToId() {
        assertNotNull(this.subscriptionOne.getSubscribedTo(), "subscriptionOne subscriberId should not be null");
        assertEquals(this.subscribedTo, this.subscriptionOne.getSubscribedTo(), "subscriptionOne subscribedToId should be set to subscriberId");
    }

    @Test
    void setSubscriberToId() {
        User newSubscribedTo =  new User();
        newSubscribedTo.setId(UUID.randomUUID());

        this.subscriptionOne.setSubscribedTo(newSubscribedTo);

        assertNotEquals(this.subscribedTo, this.subscriptionOne.getSubscribedTo(), "subscriptionOne subscribedToId should not bee equal to old id");
        assertEquals(newSubscribedTo, this.subscriptionOne.getSubscribedTo(), "subscriptionOne subscribedToId should be equal to newSubscribedToId");
    }
}