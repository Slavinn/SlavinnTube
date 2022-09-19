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
        UUID viewVideoId = viewOne.getVideoId().getId();
        given(viewRepository.getViewsByVideoId(viewVideoId)).willReturn((List.of(viewOne)));

        List<View> viewList = viewService.getViewsByVideoId(viewVideoId);

        assertNotNull(viewList);
        assertThat(viewList.size()).isEqualTo(1);

    }

    @Test
    void getViewsByUserId() {
        UUID viewUserId = viewOne.getUserId().getId();

        given(viewRepository.getViewsByUserId(viewUserId)).willReturn(List.of(viewOne));

        List<View> viewList = viewService.getViewsByUserId(viewUserId);

        assertNotNull(viewList);
        assertThat(viewList.size()).isEqualTo(1);
    }

    @Test
    void getById() {
        given(viewRepository.getReferenceById(viewOne.getId())).willReturn(viewOne);

        Optional<View> currentView = viewService.getById(viewOne.getId());

        assertNotNull(currentView);
    }

    @Test
    void saveView() {
        given(viewRepository.getReferenceById(viewOne.getId())).willReturn(null);

        given(viewRepository.save(viewOne)).willReturn(viewOne);

        View viewSaved = viewService.saveView(viewOne);

        assertNotNull(viewSaved);
    }

    @Test
    void updateView() {
        given(viewRepository.save(viewOne)).willReturn(viewOne);

        Video newVideo = new Video();
        viewOne.setVideoId(newVideo);

        User newUser = new User();
        viewOne.setUserId(newUser);

        View updatedView = viewService.updateView(viewOne);

        assertThat(updatedView.getVideoId()).isEqualTo(newVideo);
        assertThat(updatedView.getUserId()).isEqualTo(newUser);
    }

    @Test
    void deleteById() {
        UUID viewId = viewOne.getId();

        willDoNothing().given(viewRepository).deleteById(viewId);

        viewService.deleteById(viewId);

        verify(viewRepository, times(1)).deleteById(viewId);
    }
}