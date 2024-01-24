package com.example.practice.practice.service;

import com.example.practice.practice.entity.User;
import org.springframework.http.ResponseEntity;

public interface UserService {
    public ResponseEntity<User> CreateUser(User user);
}
