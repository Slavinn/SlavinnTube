package com.example.slavinntube.service;

import com.example.slavinntube.entity.User;

import java.util.List;
import java.util.UUID;

public interface UserService {

    public List<User> findAll();
    public User getById(UUID user_id);
    public void save(User user);
    public void update(User user);
    public void deleteById(UUID user_id);

}
