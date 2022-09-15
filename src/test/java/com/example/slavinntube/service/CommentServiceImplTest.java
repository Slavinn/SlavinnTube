package com.example.slavinntube.service;

import com.example.slavinntube.entity.Comment;
import com.example.slavinntube.entity.User;
import com.example.slavinntube.entity.Video;
import com.example.slavinntube.repository.CommentRepository;
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

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class CommentServiceImplTest {

    @Mock
    CommentRepository commentRepository;

    @InjectMocks
    CommentServiceImpl commentService;

    Comment commentOne;

    @BeforeEach
    void setUp() {
        this.commentOne = new Comment();
        this.commentOne.setUser(new User());
        this.commentOne.setVideo(new Video());
    }

    @Test
    void getAllCommentsByVideoId() {
        UUID videoId = this.commentOne.getVideo().getId();

        given(commentRepository.getAllCommentsByVideoId(videoId))
                .willReturn(List.of(commentOne));

        List<Comment> commentList = commentService.getAllCommentsByVideoId(videoId);

        assertNotNull(commentList);
        assertThat(commentList.size()).isEqualTo(1);
    }

    @Test
    void getALllCommentsByUserId() {
        UUID userId = this.commentOne.getUser().getId();

        given(commentRepository.getALllCommentsByUserId(userId))
                .willReturn(List.of(commentOne));

        List<Comment> commentList = commentService.getALllCommentsByUserId(userId);

        assertNotNull(commentList);
        assertThat(commentList.size()).isEqualTo(1);
    }

    @Test
    void getById() {
        UUID commentId = this.commentOne.getId();

        given(commentRepository.getReferenceById(commentOne.getId()))
                .willReturn(commentOne);

        Comment savedComment = commentService.getById(commentId).orElse(null);

        assertNotNull(savedComment);
    }

    @Test
    void saveComment() {

        given(commentRepository.getReferenceById(this.commentOne.getId())).willReturn(null);

        given(commentRepository.save(commentOne)).willReturn(commentOne);

        Comment savedComment = commentService.saveComment(commentOne);

        assertNotNull(savedComment);


    }

    @Test
    void updateComment() {
        given(commentRepository.save(commentOne)).willReturn(commentOne);
        this.commentOne.setText("new Text");

        Comment updatedComment = commentService.updateComment(commentOne);

        assertThat(updatedComment.getText()).isEqualTo("new Text");
    }

    @Test
    void deleteById() {
        UUID commentId = this.commentOne.getId();
        willDoNothing().given(commentRepository).deleteById(commentId);

        commentService.deleteById(commentId);

        verify(commentRepository, times(1)).deleteById(commentId);
    }
}