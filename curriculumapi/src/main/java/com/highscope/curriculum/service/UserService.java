// src/main/java/com/highscope/curriculum/service/UserService.java
package com.highscope.curriculum.service;

import com.highscope.curriculum.dto.UserDTO;
import com.highscope.curriculum.model.Role;
import com.highscope.curriculum.model.User;
import com.highscope.curriculum.repository.RoleRepository;
import com.highscope.curriculum.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public User createUser(UserDTO request) {
        Role role = roleRepository.findById(request.getRoleId().longValue())
                .orElseThrow(() -> new RuntimeException("Role not found"));

        User user = User.builder()
                .username(request.getUsername())
                .email(request.getEmail())
                .passwordHash(passwordEncoder.encode(request.getPassword()))
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .phoneNumber(request.getPhoneNumber())
                .hsId(request.getHsId())
                .role(role)
                .isActive(true)
                .isPasswordUpdated(false)
                .build();

        return userRepository.save(user);
    }
}