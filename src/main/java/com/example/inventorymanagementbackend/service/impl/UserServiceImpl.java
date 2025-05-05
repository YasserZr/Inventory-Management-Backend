package com.example.inventorymanagementbackend.service.impl;

import com.example.inventorymanagementbackend.exception.ResourceNotFoundException;
import com.example.inventorymanagementbackend.model.User;
import com.example.inventorymanagementbackend.repository.UserRepository;
import com.example.inventorymanagementbackend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
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
    public Optional<User> getUserById(Long id) {
        return userRepository.findById(id);
    }

    @Override
    public Optional<User> getUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public List<User> getUsersByRole(String role) {
        return userRepository.findByRole(role);
    }

    @Override
    public List<User> searchUsersByName(String name) {
        return userRepository.findByFirstnameContainingIgnoreCaseOrLastnameContainingIgnoreCase(name, name);
    }

    @Override
    public User saveUser(User user) {
        if (user.getId() == null) {
            user.setCreatedAt(LocalDateTime.now());
        }
        user.setUpdatedAt(LocalDateTime.now());
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(Long id, User userDetails) {
        return userRepository.findById(id)
                .map(user -> {
                    user.setUsername(userDetails.getUsername());
                    user.setEmail(userDetails.getEmail());
                    // Don't update password unless explicitly provided with a new value
                    if (userDetails.getPassword() != null && !userDetails.getPassword().isEmpty()) {
                        user.setPassword(userDetails.getPassword()); // In real app, encrypt password
                    }
                    user.setFirstname(userDetails.getFirstname());
                    user.setLastname(userDetails.getLastname());
                    user.setAddress(userDetails.getAddress());
                    user.setPhoneNumber(userDetails.getPhoneNumber());
                    user.setWorkAddress(userDetails.getWorkAddress());
                    user.setCompanyContactNumber(userDetails.getCompanyContactNumber());
                    user.setCompanyEmail(userDetails.getCompanyEmail());
                    user.setRole(userDetails.getRole());
                    user.setImage(userDetails.getImage());
                    user.setUpdatedAt(LocalDateTime.now());
                    return userRepository.save(user);
                })
                .orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
    }
}