package com.example.slavinntube.service;

import com.example.slavinntube.entity.User;
import com.example.slavinntube.entity.Video;
import com.example.slavinntube.entity.View;
import com.example.slavinntube.repository.ViewRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class ViewServiceImplTest {

    @Mock
    ViewRepository viewRepository;

    @InjectMocks
    ViewServiceImpl viewService;

    View viewOne;

    @BeforeEach
    void setUp() {
        this.viewOne = new View();
        this.viewOne.setVideoId(new Video());
        this.viewOne.setUserId(new User());
    }

    @Test
    void getViewsByVideoId() {
    }

    @Test
    void getViewsByUserId() {
    }

    @Test
    void getById() {
    }

    @Test
    void saveView() {
    }

    @Test
    void updateView() {
    }

    @Test
    void deleteById() {
    }
}