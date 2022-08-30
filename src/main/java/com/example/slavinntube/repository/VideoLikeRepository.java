package com.example.slavinntube.repository;

import com.example.slavinntube.entity.VideoLike;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface VideoLikeRepository extends JpaRepository<VideoLike, UUID> {
}
