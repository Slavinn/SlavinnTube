package com.example.slavinntube.VideoLike.service;

import com.example.slavinntube.User.entity.Impl.UserImpl;
import com.example.slavinntube.Video.entity.Video;
import com.example.slavinntube.Video.service.Impl.VideoLikeServiceImpl;
import com.example.slavinntube.VideoLike.entity.VideoLike;
import com.example.slavinntube.User.repository.VideoLikeRepository;
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
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class VideoLikeServiceImplTest {

    @Mock
    VideoLikeRepository videoLikeRepository;

    @InjectMocks
    VideoLikeServiceImpl videoLikeService;

    VideoLike videoLike;

    @BeforeEach
    void setUp() {
        this.videoLike = new VideoLike();
        videoLike.setVideo(new Video());
        videoLike.setUser(new UserImpl());
    }

    @Test
    void getVideoLikesByUserId() {
        UUID userId = videoLike.getUser().getId();

        given(videoLikeRepository.getVideoLikesByUserId(userId)).willReturn(List.of(videoLike));


        List<VideoLike> videoLikeList = videoLikeService.getVideoLikesByUserId(userId);

        assertNotNull(videoLikeList);
        assertThat(videoLikeList.size()).isEqualTo(1);
    }

    @Test
    void getVideoLikesByVideoId() {
        UUID videoId = videoLike.getVideo().getId();

        given(videoLikeRepository.getVideoLikesByVideoId(videoId))
                .willReturn(List.of(videoLike));

        List<VideoLike> videoLikeList = videoLikeService.getVideoLikesByVideoId(videoId);

        assertNotNull(videoLikeList);
        assertThat(videoLikeList.size()).isEqualTo(1);
    }

    @Test
    void getById() {
        given(videoLikeRepository.getReferenceById(videoLike.getId())).willReturn(videoLike);

        VideoLike savedVideoLike = videoLikeService.getById(videoLike.getId()).orElse(null);

        assertNotNull(savedVideoLike);
    }

    @Test
    void saveVideoLike() {
        given(videoLikeRepository.getReferenceById(videoLike.getId()))
                .willReturn(null);

        given(videoLikeRepository.save(videoLike)).willReturn(videoLike);

        VideoLike savedVideoLike = videoLikeService.saveVideoLike(videoLike);

        assertNotNull(savedVideoLike);
    }

    @Test
    void deleteById() {

        UUID videoLikeId = videoLike.getId();

        willDoNothing().given(videoLikeRepository).deleteById(videoLikeId);

        videoLikeService.deleteById(videoLikeId);

        verify(videoLikeRepository, times(1)).deleteById(videoLikeId);
    }
}