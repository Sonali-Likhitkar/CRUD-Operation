package com.example.practice.practice.controller;

import com.example.practice.practice.constant.UserConstant;
import com.example.practice.practice.entity.dto.JwtRequestDto;
import com.example.practice.practice.entity.dto.JwtResponseDto;
import com.example.practice.practice.exception.UserException;
import com.example.practice.practice.security.JwtHelper;
import com.example.practice.practice.serviceimpl.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthenticationController {

    private final UserDetailsServiceImpl userDetailsServiceImpl;

    private final AuthenticationManager authenticationManager;
    private final JwtHelper jwtHelper;

    public AuthenticationController(UserDetailsServiceImpl userDetailsServiceImpl, AuthenticationManager authenticationManager, JwtHelper jwtHelper) {
        this.userDetailsServiceImpl = userDetailsServiceImpl;
        this.authenticationManager = authenticationManager;
        this.jwtHelper = jwtHelper;
    }

    public final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/hey")
    public String varchar() {
        return "hello this is string";
    }


    @PostMapping("/login")
    public ResponseEntity<JwtResponseDto> loginApi(@RequestBody JwtRequestDto jwtRequestDto) {
        try {
            this.authenticate(jwtRequestDto.getEmail(), jwtRequestDto.getPassword());

        } catch (Exception e) {
            throw new UserException(HttpStatus.NOT_FOUND, UserConstant.EMAIL_NOT_FOUND);
        }
        UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(jwtRequestDto.getEmail());
        String token = this.jwtHelper.generateToken(userDetails);
        return ResponseEntity.ok(JwtResponseDto.builder().Token(token).build());
    }

    private void authenticate(String email, String password) {
        try {
            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
        } catch (DisabledException e) {
            throw new UserException(HttpStatus.NOT_FOUND, UserConstant.USER_DISABLE);

        } catch (Exception e) {
            throw new UserException(HttpStatus.BAD_REQUEST, UserConstant.INVALID_CREDENTIAL);
        }
    }
}