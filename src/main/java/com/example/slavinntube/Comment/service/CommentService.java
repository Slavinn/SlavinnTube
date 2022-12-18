package com.example.slavinntube.Comment.service;

import com.example.slavinntube.Comment.entity.Comment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommentService {
    List<Comment> getAllCommentsByVideoId(UUID videoId);
    List<Comment> getAllCommentsByUserId(UUID userId);
    Optional<Comment> getById(UUID commentId);
    Comment saveComment(Comment comment);
    Comment updateComment(Comment comment);
    void deleteById(UUID commentId);

}
