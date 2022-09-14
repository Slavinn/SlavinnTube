package com.example.slavinntube.service;

import com.example.slavinntube.entity.User;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface UserService {
    List<User> getAllUsers();
    Optional<User> getById(UUID userId);
    Optional<User> getByEmail(String email);
    Optional<User> getByUsername(String username);
    User saveUser(User user);
    User updateUser(User user);
    void deleteById(UUID userId);



}
