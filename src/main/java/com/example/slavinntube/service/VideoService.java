package com.example.slavinntube.service;

import com.example.slavinntube.entity.Video;

import java.util.List;
import java.util.UUID;

public interface VideoService {

    public List<Video> findAll();

    public Video getBYId(UUID video_id);

    public void save(Video video);

    public void update(Video video);

    public void deleteById(UUID video_id);

}
