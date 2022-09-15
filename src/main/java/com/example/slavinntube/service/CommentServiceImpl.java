package com.example.slavinntube.service;

import com.example.slavinntube.entity.Comment;
import com.example.slavinntube.repository.CommentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;

    @Autowired
    public CommentServiceImpl(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    @Override
    public List<Comment> getAllCommentsByVideoId(UUID videoId) {
        return commentRepository.getAllCommentsByVideoId(videoId);
    }

    @Override
    public List<Comment> getALllCommentsByUserId(UUID userId) {
        return commentRepository.getALllCommentsByUserId(userId);
    }

    @Override
    public Optional<Comment> getById(UUID commentId) {
        return Optional.of(commentRepository.getReferenceById(commentId));
    }

    @Override
    public Comment saveComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public Comment updateComment(Comment comment) {
        return commentRepository.save(comment);
    }

    @Override
    public void deleteById(UUID commentId) {
        commentRepository.deleteById(commentId);
    }
}
