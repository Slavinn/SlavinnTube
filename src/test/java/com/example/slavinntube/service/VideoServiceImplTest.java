package com.example.slavinntube.service;

import com.example.slavinntube.entity.Video;
import com.example.slavinntube.repository.VideoRepository;
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
class VideoServiceImplTest {

    @Mock
    VideoRepository videoRepository;

    @InjectMocks
    VideoServiceImpl videoService;

    Video videoOne;

    @BeforeEach
    void setUp() {

    }

    @Test
    void getAllVideos() {
    }

    @Test
    void getById() {
    }

    @Test
    void saveVideo() {
    }

    @Test
    void updateVideo() {
    }

    @Test
    void deleteById() {
    }
}