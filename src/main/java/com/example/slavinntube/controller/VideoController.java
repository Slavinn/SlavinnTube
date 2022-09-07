package com.example.slavinntube.controller;


import com.example.slavinntube.entity.Video;
import com.example.slavinntube.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class VideoController {

    private VideoService videoService;

    @Autowired
    public VideoController(VideoService videoService) {
        this.videoService = videoService;
    }

    @GetMapping("/videos")
    public List<Video> getVideos() {
        return videoService.findAll();
    }

    @PostMapping("/videos")
    public void  saveVideo(@RequestBody Video video) {
        videoService.save(video);

    }

    @PutMapping("/videos/")
    public void updateVideo(@RequestBody Video video) {
        videoService.update(video);
    }

    @DeleteMapping("/videos/{video_id}")
    public void deleteVideo(@PathVariable UUID video_id) {
        videoService.deleteById(video_id);
    }
}