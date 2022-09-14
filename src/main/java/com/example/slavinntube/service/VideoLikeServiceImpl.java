package com.example.slavinntube.service;


import com.example.slavinntube.entity.VideoLike;
import com.example.slavinntube.repository.VideoLikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class VideoLikeServiceImpl implements VideoLikeService{

    private final VideoLikeRepository videoLikeRepository;

    @Autowired
    public VideoLikeServiceImpl(VideoLikeRepository videoLikeRepository) {
        this.videoLikeRepository = videoLikeRepository;
    }

    @Override
    public List<VideoLike> getVideoLikesByUserId(UUID userId) {
        return videoLikeRepository.getVideoLikesByUserId(userId);
    }

    @Override
    public List<VideoLike> getVideoLikesByVideoId(UUID videoId) {
        return videoLikeRepository.getVideoLikesByVideoId(videoId);
    }

    @Override
    public Optional<VideoLike> getById(UUID videoLikeId) {
        return Optional.of(videoLikeRepository.getReferenceById(videoLikeId));
    }

    @Override
    public VideoLike saveVideoLike(VideoLike videoLike) {
        return videoLikeRepository.save(videoLike);
    }

    @Override
    public void deleteById(UUID videoLikeId) {
        videoLikeRepository.deleteById(videoLikeId);
    }
}
