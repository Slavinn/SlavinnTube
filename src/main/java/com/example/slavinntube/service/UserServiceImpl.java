package com.example.slavinntube.service;

import com.example.slavinntube.entity.User;
import com.example.slavinntube.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<User> getById(UUID userId) {
        return Optional.of(userRepository.getReferenceById(userId));
    }

    @Override
    public Optional<User> getByEmail(String email) {
        return Optional.ofNullable(userRepository.getByEmail(email));
    }

    @Override
    public Optional<User> getByUsername(String username) {
        return Optional.ofNullable(userRepository.getByUsername(username));
    }
    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(UUID userId) {
        userRepository.deleteById(userId);
    }
}
