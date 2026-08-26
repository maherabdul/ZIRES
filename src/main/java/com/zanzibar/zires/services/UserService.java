package com.zanzibar.zires.service;  // ← Changed from employment to zires

import com.zanzibar.zires.entity.User;  // ← Changed import
import com.zanzibar.zires.repository.UserRepository;  // ← Changed import
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Get user by ID
    public User getUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    // Create user
    public User createUser(User user) {
        // Check if email already exists
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new RuntimeException("Email already exists: " + user.getEmail());
        }
        return userRepository.save(user);
    }

    // Update user
    public User updateUser(Long id, User updatedUser) {
        User user = getUserById(id);

        user.setFullName(updatedUser.getFullName());
        user.setEmail(updatedUser.getEmail());
        user.setPhone(updatedUser.getPhone());
        user.setPassword(updatedUser.getPassword());
        user.setRole(updatedUser.getRole());
        user.setStatus(updatedUser.getStatus());

        return userRepository.save(user);
    }

    // Delete user
    public void deleteUser(Long id) {
        User user = getUserById(id);
        userRepository.delete(user);
    }
}