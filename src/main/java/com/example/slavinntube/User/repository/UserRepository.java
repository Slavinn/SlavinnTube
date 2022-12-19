package com.example.slavinntube.User.repository;

import com.example.slavinntube.User.entity.Impl.UserImpl;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserImpl, UUID> {

    UserImpl getByEmail(String email);
    UserImpl getByUsername(String username);
}
