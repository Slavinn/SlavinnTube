package com.example.slavinntube.service;


import com.example.slavinntube.entity.Video;
import com.example.slavinntube.repository.VideoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class VideoServiceImpl implements VideoService {


    private VideoRepository videoRepository;

    @Autowired
    public VideoServiceImpl(VideoRepository videoRepository) {
        this.videoRepository = videoRepository;
    }

    @Override
    public List<Video> findAll() {
        return videoRepository.findAll();
    }

    @Override
    public Video getBYId(UUID video_id) {
        return videoRepository.getReferenceById(video_id);
    }

    @Override
    public void save(Video video) {
        videoRepository.save(video);
    }

    @Override
    public void update(Video video) {
        videoRepository.save(video);
    }

    @Override
    public void deleteById(UUID video_id) {
        videoRepository.deleteById(video_id);
    }
}
