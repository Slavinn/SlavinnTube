package com.example.slavinntube.service;


import com.example.slavinntube.entity.View;
import com.example.slavinntube.repository.ViewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class ViewServiceImpl implements ViewService {

    private final ViewRepository viewRepository;

    @Autowired
    public ViewServiceImpl(ViewRepository viewRepository) {
        this.viewRepository = viewRepository;
    }

    @Override
    public List<View> getViewsByVideoId(UUID videoId) {
        return viewRepository.getViewsByVideoId(videoId);
    }

    @Override
    public List<View> getViewsByUserId(UUID userId) {
        return viewRepository.getViewsByUserId(userId);
    }

    @Override
    public Optional<View> getById(UUID viewId) {
        return Optional.of(viewRepository.getReferenceById(viewId));
    }

    @Override
    public View saveView(View view) {
        return viewRepository.save(view);
    }

    @Override
    public View updateView(View view) {
        return viewRepository.save(view);
    }

    @Override
    public void deleteById(UUID viewId) {
        viewRepository.deleteById(viewId);
    }
}
