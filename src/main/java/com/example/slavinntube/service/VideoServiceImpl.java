package com.example.slavinntube.service;


import com.example.slavinntube.entity.Video;
import com.example.slavinntube.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class VideoServiceImpl implements VideoService {


    private final VideoRepository videoRepository;

    @Autowired
    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public List<Video> getAllVideos() {
        return videoRepository.findAll();
    }

    @Override
    public Optional<Video> getById(UUID video_id) {
        return Optional.of(videoRepository.getReferenceById(video_id));
    }

    @Override
    public void saveVideo(Video video) {
        videoRepository.save(video);
    }

    @Override
    public void updateVideo(Video video) {
        videoRepository.save(video);
    }

    @Override
    public void deleteById(UUID video_id) {
        videoRepository.deleteById(video_id);
    }
}
