package com.example.slavinntube.controller;


import com.example.slavinntube.entity.User;
import com.example.slavinntube.exeptionhandling.user.UserErrorResponse;
import com.example.slavinntube.exeptionhandling.user.UserExistsException;
import com.example.slavinntube.exeptionhandling.user.UserNotFoundException;
import com.example.slavinntube.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/api/v1")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        return new ResponseEntity<>(this.userService.getAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<User> createUser(@RequestBody User user) throws UserExistsException {
        // check if email already exists
        Optional<User> existingEmail = userService.getByEmail(user.getEmail());
        // check if username already exists
        Optional<User> existingUsername = userService.getByUsername(user.getUsername());

        // throw exception if either email or username was found in database.
        if (existingUsername.isEmpty() || existingEmail.isEmpty()) {
            // return message and conflict response
            throw new UserExistsException("UserName or Email already Exists");
        } else {
            // save to database and return user, created response
            System.out.println(user);
            userService.saveUser(user);
            return new ResponseEntity<>(user, HttpStatus.CREATED);
        }
    }

    @PutMapping("/users")
    public ResponseEntity<User> updatedUser(@RequestBody User user) throws UserExistsException {
        // check if email already exists
        Optional<User> existingEmail = userService.getByEmail(user.getEmail());
        // check if username already exists
        Optional<User> existingUsername = userService.getByUsername(user.getUsername());

        // throw exception if either email or username was found in database.
        if (existingUsername.isEmpty() || existingEmail.isEmpty()) {
            // return message and conflict response
            throw new UserExistsException("UserName or Email already Exists");
        } else {
            // save to database and return user, created response
            userService.updateUser(user);
            return new ResponseEntity<>(user, HttpStatus.OK);
        }
    }

    @DeleteMapping("/users/{user_id}")
    public ResponseEntity deleteUser(@PathVariable UUID user_id) {
        Optional<User> existingUser = userService.getById(user_id);
        if (existingUser.isEmpty()) {
            throw new UserNotFoundException("User was not found - ");
        }
        userService.deleteById(user_id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException exc) {
        UserErrorResponse error = new UserErrorResponse();

        error.setStatus(HttpStatus.NOT_FOUND.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UserExistsException exc) {
        UserErrorResponse error = new UserErrorResponse();

        error.setStatus(HttpStatus.CONFLICT.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(Exception exc) {
        UserErrorResponse error = new UserErrorResponse();

        error.setStatus(HttpStatus.BAD_REQUEST.value());
        error.setMessage(exc.getMessage());
        error.setTimestamp(System.currentTimeMillis());

        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

}
