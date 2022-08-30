package com.example.slavinntube.controller;


import com.example.slavinntube.entity.User;
import com.example.slavinntube.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAll();
    }

    @PostMapping("/users")
    public void createUser(@RequestBody User user) {
        userService.save(user);
    }

    @PutMapping("/users")
    public void updatedUser(@RequestBody User user) {
        userService.update(user);
    }

    @DeleteMapping("/users/{user_id}")
    public void deleteUser(@PathVariable UUID user_id) {
        userService.deleteById(user_id);

    }

}
