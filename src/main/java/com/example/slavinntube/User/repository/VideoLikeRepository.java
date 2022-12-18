package com.example.slavinntube.User.repository;

import com.example.slavinntube.VideoLike.entity.VideoLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VideoLikeRepository extends JpaRepository<VideoLike, UUID> {
    List<VideoLike> getVideoLikesByUserId(UUID userId);
    List<VideoLike> getVideoLikesByVideoId(UUID videoId);




}
