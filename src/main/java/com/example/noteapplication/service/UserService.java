package com.example.noteapplication.service;

import com.example.noteapplication.dto.UserDTO;
import com.example.noteapplication.model.User;

import java.util.List;

public interface UserService {
    void updateUserRole(Long userId, String roleName);

    List<User> getAllUsers();

    UserDTO getUserById(Long id);
}
