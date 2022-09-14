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

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


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
        this.videoOne = new Video();
    }

    @Test
    void getAllVideos() {
        Video videoTwo = new Video();

        given(videoRepository.findAll()).willReturn(List.of(videoOne, videoTwo));

        List<Video> videoList = videoService.getAllVideos();

        assertNotNull(videoList);
        assertThat(videoList.size()).isEqualTo(2);
    }

    @Test
    void getById() {
        given(videoRepository.getReferenceById(videoOne.getId())).willReturn(videoOne);

        Video savedVideo = videoService.getById(videoOne.getId()).orElse(null);

        assertNotNull(savedVideo);
    }

    @Test
    void saveVideo() {
        given(videoRepository.getReferenceById(videoOne.getId())).willReturn(null);

        given(videoRepository.save(videoOne)).willReturn(videoOne);

        Video videoSaved = videoService.saveVideo(videoOne);

        assertNotNull(videoSaved);
    }

    @Test
    void updateVideo() {
        given(videoRepository.save(videoOne)).willReturn(videoOne);
        videoOne.setUrl("newURL");
        videoOne.setDescription("new Description");
        videoOne.setTitle("new Title One");

        Video updatedVideo = videoService.updateVideo(videoOne);

        assertThat(videoOne.getUrl()).isEqualTo("newURL");
        assertThat(videoOne.getDescription()).isEqualTo("new Description");
        assertThat(videoOne.getTitle()).isEqualTo("new Title One");
    }

    @Test
    void deleteById() {
        UUID videoId = videoOne.getId();

        willDoNothing().given(videoRepository).deleteById(videoId);

        videoService.deleteById(videoId);

        verify(videoRepository, times(1)).deleteById(videoId);

    }
}