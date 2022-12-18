package com.example.slavinntube.View.service;

import com.example.slavinntube.View.entity.View;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface ViewService {
    List<View> getViewsByVideoId(UUID videoId);
    List<View> getViewsByUserId(UUID userId);
    Optional<View> getById(UUID viewId);
    View saveView(View view);
    View updateView(View view);
    void deleteById(UUID viewId);

}
