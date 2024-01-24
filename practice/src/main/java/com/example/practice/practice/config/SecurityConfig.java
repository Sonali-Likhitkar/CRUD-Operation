package com.example.practice.practice.config;

import com.example.practice.practice.security.JwtAuthenticationEntryPoint;
import com.example.practice.practice.security.JwtAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {

    private final JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;

    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    public SecurityConfig(JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint,JwtAuthenticationFilter jwtAuthenticationFilter){
        this.jwtAuthenticationEntryPoint=jwtAuthenticationEntryPoint;
        this.jwtAuthenticationFilter=jwtAuthenticationFilter;
    }


@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers(
                    new AntPathRequestMatcher("/login"),
                    new AntPathRequestMatcher("/v3/api-docs/**"),
                    new AntPathRequestMatcher("/swagger-ui/**"),
                    new AntPathRequestMatcher("/employeeController/**"),
                    new AntPathRequestMatcher("/userController/**"),
                    new AntPathRequestMatcher("/studentController/**"),
                    new AntPathRequestMatcher("/controller/**"),
                    new AntPathRequestMatcher("/tutorialController/**")
            ).permitAll()
            .anyRequest()
            .authenticated()
            .and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
            .and()
            .sessionManagement()
            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
            .and()
            .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
            .build();
}

    }