package com.example.slavinntube.service;

import com.example.slavinntube.entity.Subscription;
import com.example.slavinntube.entity.User;
import com.example.slavinntube.repository.SubscriptionRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class SubscriptionServiceImplTest {

    @Mock
    SubscriptionRepository subscriptionRepository;

    @InjectMocks
    SubscriptionServiceImpl subscriptionService;


    Subscription subscriptionOne;

    @BeforeEach
    void setUp() {
        subscriptionOne = new Subscription(new User(), new User());
    }

    @Test
    void getSubscriptionsBySubscriberId() {
        UUID subscriberId = subscriptionOne.getSubscriber().getId();

        given(subscriptionRepository.getSubscriptionsBySubscriberId(subscriberId)).willReturn(List.of(subscriptionOne));

        List<Subscription> subscriptionList = subscriptionService.getSubscriptionsBySubscriberId(subscriberId);

        assertNotNull(subscriptionList);
        assertThat(subscriptionList.size()).isEqualTo(1);

    }

    @Test
    void getSubscriptionBySubscribedId() {
        UUID subscribedId = subscriptionOne.getSubscribedTo().getId();

        given(subscriptionRepository.getSubscriptionBySubscribedId(subscribedId)).willReturn(List.of(subscriptionOne));

        List<Subscription> subscriptionList = subscriptionService.getSubscriptionBySubscribedId(subscribedId);

        assertNotNull(subscriptionList);
        assertThat(subscriptionList.size()).isEqualTo(1);
    }

    @Test
    void getSubscriptionById() {
        given(subscriptionRepository.getReferenceById(subscriptionOne.getId())).willReturn(subscriptionOne);

        Optional<Subscription> currentSubscription = subscriptionService.getSubscriptionById(subscriptionOne.getId());

        assertNotNull(currentSubscription);
    }

    @Test
    void saveSubscription() {
        given(subscriptionRepository.getReferenceById(subscriptionOne.getId())).willReturn(null);

        given(subscriptionRepository.save(subscriptionOne)).willReturn(subscriptionOne);

        Subscription savedSubscription = subscriptionService.saveSubscription(subscriptionOne);

        assertNotNull(savedSubscription);
    }

    @Test
    void updateSubscription() {
        given(subscriptionRepository.getReferenceById(subscriptionOne.getId())).willReturn(subscriptionOne);

        User newSubscriber = new User();
        User newSubscribed = new User();
        subscriptionOne.setSubscriber(newSubscriber);
        subscriptionOne.setSubscribedTo(newSubscribed);

        Subscription updatedSubscription = subscriptionService.updateSubscription(subscriptionOne);

        assertThat(subscriptionOne.getSubscriber()).isEqualTo(newSubscriber);
        assertThat(subscriptionOne.getSubscribedTo()).isEqualTo(newSubscribed);
    }

    @Test
    void deleteById() {
        UUID subscriptionId = subscriptionOne.getId();

        willDoNothing().given(subscriptionRepository).deleteById(subscriptionId);

        subscriptionService.deleteById(subscriptionId);

        verify(subscriptionRepository, times(1)).deleteById(subscriptionId);
    }
}