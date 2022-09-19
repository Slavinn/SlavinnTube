package com.example.slavinntube.service;


import com.example.slavinntube.entity.Subscription;
import com.example.slavinntube.repository.SubscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService{

    private final SubscriptionRepository subscriptionRepository;

    @Autowired
    public SubscriptionServiceImpl(SubscriptionRepository subscriptionRepository) {
        this.subscriptionRepository = subscriptionRepository;
    }

    @Override
    public List<Subscription> getSubscriptionsBySubscriberId(UUID subscriberId) {
        return subscriptionRepository.getSubscriptionsBySubscriberId(subscriberId);
    }

    @Override
    public List<Subscription> getSubscriptionBySubscribedToId(UUID subscribedId) {
        return subscriptionRepository.getSubscriptionBySubscribedToId(subscribedId);
    }

    @Override
    public Optional<Subscription> getSubscriptionById(UUID subscriptionId) {
        return Optional.of(subscriptionRepository.getReferenceById(subscriptionId));
    }

    @Override
    public Subscription saveSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public Subscription updateSubscription(Subscription subscription) {
        return subscriptionRepository.save(subscription);
    }

    @Override
    public void deleteById(UUID subscriptionId) {
        subscriptionRepository.deleteById(subscriptionId);
    }
}
