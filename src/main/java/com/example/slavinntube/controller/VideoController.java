package com.example.slavinntube.controller;


import com.example.slavinntube.entity.Video;
import com.example.slavinntube.exeptionhandling.ErrorResponse;
import com.example.slavinntube.exeptionhandling.user.UserNotFoundException;
import com.example.slavinntube.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
        return videoService.getAllVideos();
    }

    @PostMapping("/videos")
    public void  saveVideo(@RequestBody Video video) {
        videoService.saveVideo(video);

    }

    @PutMapping("/videos/")
    public void updateVideo(@RequestBody Video video) {
        videoService.updateVideo(video);
    }

    @DeleteMapping("/videos/{video_id}")
    public void deleteVideo(@PathVariable UUID video_id) {
        videoService.deleteById(video_id);
    }


    @ExceptionHandler
    public ResponseEntity<ErrorResponse> handleException(UserNotFoundException exc) {
        ErrorResponse error = new ErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}
