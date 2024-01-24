package com.example.practice.practice.config;

import com.example.practice.practice.repository.StudentRepository;
import com.example.practice.practice.serviceimpl.UserDetailsServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class MyConfig {

    private final StudentRepository repository;

    public MyConfig(StudentRepository repository) {
        this.repository = repository;
    }

//    @Bean
//    public UserDetailsService userDetailsService() {
//        return new UserDetailsServiceImpl(repository);
//    }

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
