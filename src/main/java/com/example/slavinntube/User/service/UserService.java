package com.example.slavinntube.User.service;

import com.example.slavinntube.User.entity.Impl.UserImpl;

import java.util.List;
import java.util.Optional;
import java.util.UUID;


public interface UserService {
    List<UserImpl> getAllUsers();
    Optional<UserImpl> getById(UUID userId);
    Optional<UserImpl> getByEmail(String email);
    Optional<UserImpl> getByUsername(String username);
    UserImpl saveUser(UserImpl user);
    UserImpl updateUser(UserImpl user);
    void deleteById(UUID userId);



}
