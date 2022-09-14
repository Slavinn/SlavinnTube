package com.example.slavinntube.service;

import com.example.slavinntube.entity.VideoLike;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VideoLikeService {
    List<VideoLike> getVideoLikesByUserId(UUID userId);
    List<VideoLike> getVideoLikesByVideoId(UUID videoId);
    Optional<VideoLike> getById(UUID videoLikeId);
    VideoLike saveVideoLike(VideoLike videoLike);
    void deleteById(UUID videoLikeId);
}
