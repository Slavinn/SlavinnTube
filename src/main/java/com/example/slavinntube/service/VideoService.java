package com.example.slavinntube.service;

import com.example.slavinntube.entity.Video;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface VideoService {

    List<Video> getAllVideos();

    Optional<Video> getById(UUID video_id);

     Video saveVideo(Video video);

     Video updateVideo(Video video);

    void deleteById(UUID video_id);

}
