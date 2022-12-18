package com.example.slavinntube.VideoLike.repository;

import com.example.slavinntube.Video.entity.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VideoRepository extends JpaRepository<Video, UUID> {
}
