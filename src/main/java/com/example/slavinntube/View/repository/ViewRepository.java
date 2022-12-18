package com.example.slavinntube.View.repository;

import com.example.slavinntube.View.entity.View;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface ViewRepository extends JpaRepository<View, UUID> {
    List<View> getViewsByVideoId(UUID videoId);
    List<View> getViewsByUserId(UUID userId);
}
