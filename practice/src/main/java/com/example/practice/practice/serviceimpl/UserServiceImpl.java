package com.example.practice.practice.serviceimpl;

import com.example.practice.practice.entity.User;
import com.example.practice.practice.repository.UserRepository;
import com.example.practice.practice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

 private final UserRepository userRepository;

 @Autowired
 private PasswordEncoder passwordEncoder;

 public UserServiceImpl(UserRepository userRepository){
     this.userRepository = userRepository;
 }

    @Override
    public ResponseEntity<User> CreateUser(User user) {
      User newUser = User.builder().email(user.getEmail()).name(user.getName())
              .password(passwordEncoder.encode(user.getPassword())).build();
      userRepository.save(newUser);
      return  ResponseEntity.ok().body(user);
            }
}
