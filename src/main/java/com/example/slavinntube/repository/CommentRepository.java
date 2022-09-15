package com.example.slavinntube.repository;

import com.example.slavinntube.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CommentRepository extends JpaRepository<Comment, UUID> {

    List<Comment> getAllCommentsByVideoId(UUID videoId);

    List<Comment> getALllCommentsByUserId(UUID userId);
}
