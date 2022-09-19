package com.example.slavinntube.repository;

import com.example.slavinntube.entity.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface SubscriptionRepository extends JpaRepository<Subscription, UUID> {

    List<Subscription> getSubscriptionsBySubscriberId(UUID subscriberId);
    List<Subscription> getSubscriptionBySubscribedToId(UUID subscribedId);
}
