package com.example.practice.practice.config;

import com.example.practice.practice.repository.StudentRepository;
import com.example.practice.practice.serviceimpl.UserDetailsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableMethodSecurity
@EnableWebSecurity
public class MyConfig {


    @Autowired
    private StudentRepository repository;

//    @Bean
//    public UserDetailsService userDetailsService() {
//        UserDetails userDetails = User.builder().
//                username("DURGESH")
//                .password(passwordEncoder().encode("DURGESH")).roles("ADMIN").
//                build();
//        return new InMemoryUserDetailsManager(userDetails);
//    }
//    //        return new UserDetailsServiceImpl(repository);


    @Bean
//authentication
public UserDetailsService userDetailsService() {
    return new UserDetailsServiceImpl(repository);
}
    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return  new BCryptPasswordEncoder();
    }


    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder) throws Exception {
        return builder.getAuthenticationManager();
    }
}
