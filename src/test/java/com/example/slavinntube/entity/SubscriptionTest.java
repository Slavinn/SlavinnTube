package com.example.slavinntube.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class SubscriptionTest {

    UUID subscriberId;
    UUID subscribedToId;

    Subscription subscriptionOne;

    @BeforeEach
    void setUp() {
        this.subscriberId = UUID.randomUUID();
        this.subscribedToId = UUID.randomUUID();

        this.subscriptionOne = new Subscription();

        this.subscriptionOne.setSubscriberId(this.subscriberId);
        this.subscriptionOne.setSubscribedToId(this.subscribedToId);
    }

    @Test
    void getSubscriberId() {
        assertNotNull(this.subscriptionOne.getSubscriberId(), "subscriberId should not be null");
        assertEquals(this.subscriberId, this.subscriptionOne.getSubscriberId(), "subscriptionOne id should be set to subscriberId");
    }

    @Test
    void setSubscriberId() {
        UUID newSubscriberId = UUID.randomUUID();

        this.subscriptionOne.setSubscriberId(newSubscriberId);

        assertNotEquals(this.subscriberId, this.subscriptionOne.getSubscriberId(), "subscriptionOne subscriberId should not be set to old id");
        assertEquals(newSubscriberId, this.subscriptionOne.getSubscriberId(), "subscriptionOne subscriberId should be set to newSubscriberId");
    }

    @Test
    void getSubscriberToId() {
        assertNotNull(this.subscriptionOne.getSubscribedToId(), "subscriptionOne subscriberId should not be null");
        assertEquals(this.subscribedToId, this.subscriptionOne.getSubscribedToId(), "subscriptionOne subscribedToId should be set to subscriberId");
    }

    @Test
    void setSubscriberToId() {
        UUID newSubscribedToId = UUID.randomUUID();

        this.subscriptionOne.setSubscribedToId(newSubscribedToId);

        assertNotEquals(this.subscribedToId, this.subscriptionOne.getSubscribedToId(), "subscriptionOne subscribedToId should not bee equal to old id");
        assertEquals(newSubscribedToId, this.subscriptionOne.getSubscribedToId(), "subscriptionOne subscribedToId should be equal to newSubscribedToId");
    }
}