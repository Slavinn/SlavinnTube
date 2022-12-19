package com.example.slavinntube.User.service.Impl;

import com.example.slavinntube.User.entity.Impl.UserImpl;
import com.example.slavinntube.User.repository.UserRepository;
import com.example.slavinntube.User.service.UserService;
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
    public List<UserImpl> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Optional<UserImpl> getById(UUID userId) {
        return Optional.of(userRepository.getReferenceById(userId));
    }

    @Override
    public Optional<UserImpl> getByEmail(String email) {
        return Optional.ofNullable(userRepository.getByEmail(email));
    }

    @Override
    public Optional<UserImpl> getByUsername(String username) {
        return Optional.ofNullable(userRepository.getByUsername(username));
    }
    @Override
    public UserImpl saveUser(UserImpl user) {
        return userRepository.save(user);
    }

    @Override
    public UserImpl updateUser(UserImpl user) {
        return userRepository.save(user);
    }

    @Override
    public void deleteById(UUID userId) {
        userRepository.deleteById(userId);
    }
}
