package com.example.inventorymanagementbackend.service;

import com.example.inventorymanagementbackend.model.User;
import java.util.List;
import java.util.Optional;

public interface UserService {
    List<User> getAllUsers();
    Optional<User> getUserById(Long id);
    Optional<User> getUserByUsername(String username);
    Optional<User> getUserByEmail(String email);
    List<User> getUsersByRole(String role);
    List<User> searchUsersByName(String name);
    User saveUser(User user);
    void deleteUser(Long id);
    User updateUser(Long id, User userDetails);
}