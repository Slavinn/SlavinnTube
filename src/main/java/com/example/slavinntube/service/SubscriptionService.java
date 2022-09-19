package com.example.slavinntube.service;

import com.example.slavinntube.entity.Subscription;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface SubscriptionService {
    List<Subscription> getSubscriptionsBySubscriberId(UUID subscriberId);
    List<Subscription> getSubscriptionBySubscribedToId(UUID subscribedId);
    Optional<Subscription> getSubscriptionById(UUID subscriptionId);
    Subscription saveSubscription(Subscription subscription);
    Subscription updateSubscription(Subscription subscription);
    void deleteById(UUID subscriptionId);
}
