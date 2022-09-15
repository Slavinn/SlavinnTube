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
    }

    @Test
    void getALllCommentsByUserId() {
    }

    @Test
    void getById() {
    }

    @Test
    void saveComment() {
    }

    @Test
    void updateComment() {
    }

    @Test
    void deleteById() {
    }
}