package com.example.slavinntube.service;

import com.example.slavinntube.entity.User;
import com.example.slavinntube.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.junit.jupiter.MockitoSettings;
import org.mockito.quality.Strictness;

import java.util.List;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.BDDMockito.willDoNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
@MockitoSettings(strictness = Strictness.LENIENT)
class UserServiceImplTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private UserServiceImpl userService;

    private User userOne;

    @BeforeEach
    void setUp() {
        this.userOne = new User("username", "email@address.com");
    }

    @Test
    void getAllUsers() {
        User userTwo = new User("username2", "email2@address.com");

        given(userRepository.findAll()).willReturn(List.of(userOne,userTwo));

        List<User> userList = userService.getAllUsers();

        assertNotNull(userList);
        assertThat(userList.size()).isEqualTo(2);
    }

    @Test
    void getById() {
        given(userRepository.getReferenceById(userOne.getId())).willReturn(userOne);

        User savedUser = userService.getById(userOne.getId()).orElse(null);

        assertNotNull(savedUser);
    }

    @Test
    void getByEmail() {
        given(userRepository.getByEmail(userOne.getEmail())).willReturn(userOne);

        User savedUser = userService.getByEmail(userOne.getEmail()).orElse(null);

        assertNotNull(savedUser);
    }

    @Test
    void getByUsername() {
        given(userRepository.getByUsername(userOne.getUsername())).willReturn(userOne);

        User savedUser = userService.getByUsername(userOne.getUsername()).orElse(null);

        assertNotNull(savedUser);
    }

    @Test
    void saveUser() {
        given(userRepository.getReferenceById(userOne.getId()))
                .willReturn(null);

        given(userRepository.save(userOne)).willReturn(userOne);

        User savedUser = userService.saveUser(userOne);

        assertNotNull(savedUser);
    }

    @Test
    void updateUser() {
        given(userRepository.save(userOne)).willReturn(userOne);
        userOne.setEmail("newEmail@gmail.com");
        userOne.setUsername("newUsername1");

        User updatedUser = userService.updateUser(userOne);

        assertThat(updatedUser.getUsername()).isEqualTo("newUsername1");
        assertThat(updatedUser.getEmail()).isEqualTo("newEmail@gmail.com");
    }

    @Test
    void deleteById() {
        UUID userId = userOne.getId();

        willDoNothing().given(userRepository).deleteById(userId);

        userService.deleteById(userId);

        verify(userRepository, times(1)).deleteById(userId);
    }
}