package com.example.practice.practice.config;

import com.example.practice.practice.security.JwtAuthenticationEntryPoint;
import com.example.practice.practice.security.JwtAuthenticationFilter;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private JwtAuthenticationEntryPoint jwtAuthenticationEntryPoint;
    @Autowired
    private JwtAuthenticationFilter jwtAuthenticationFilter;

//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception {
//        httpSecurity.csrf(csrf -> csrf.disable())
//                .cors(cors -> cors.disable())
//                .authorizeHttpRequests(auth -> auth.requestMatchers("/api/V1/login").authenticated().requestMatchers("/getHello").permitAll().anyRequest().authenticated())
//                .exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuthenticationEntryPoint))
//                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//        return httpSecurity.build();
//        httpSecurity.csrf(csrf -> csrf.disable()).authorizeHttpRequests(auth -> auth.requestMatchers(new AntPathRequestMatcher("/getHello"), new AntPathRequestMatcher("/getAllStudents"),
//                new AntPathRequestMatcher("/api/v1/login")).permitAll().anyRequest().authenticated())
//                .exceptionHandling(ex -> ex.authenticationEntryPoint(jwtAuthenticationEntryPoint)).sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
//        httpSecurity.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
//        return httpSecurity.build();

//        return http.csrf().disable()
//                .authorizeHttpRequests()
//                .requestMatchers(
//                        new AntPathRequestMatcher("/api/V1/authentication/generate-token"),
//                        new AntPathRequestMatcher("/api/V1/user/hii"),
//                        new AntPathRequestMatcher("/api/V1/user/create"),
//                        new AntPathRequestMatcher("/api/V1/user/change-password"),
//                        new AntPathRequestMatcher("/api/V1/staff/permission/fetch-all"),
//                        new AntPathRequestMatcher("/api/V1/staff/permission/find-by-id"),
//                        new AntPathRequestMatcher("/api/V1/staff/modules/fetch-all"),
//                        new AntPathRequestMatcher("/api/V1/staff/modules/fetch-by-parent"),
//                        new AntPathRequestMatcher("/v3/api-docs/**"),
//                        new AntPathRequestMatcher("/swagger-ui/**")
//                ).permitAll()
//                .anyRequest()
//                .authenticated()
//                .and().exceptionHandling().authenticationEntryPoint(jwtAuthenticationEntryPoint)
//                .and()
//                .sessionManagement()
//                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
//                .and()
//                .authenticationProvider(authenticationProvider())
//                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
//                .build();
//    }
@Bean
public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
    return http.csrf().disable()
            .authorizeHttpRequests()
            .requestMatchers(
                    new AntPathRequestMatcher("/login"),
                    new AntPathRequestMatcher("/getHello"),
                    new AntPathRequestMatcher("/hey"),
                    new AntPathRequestMatcher("/saveStudent"),
                    new AntPathRequestMatcher("/getAllStudents"),
                    new AntPathRequestMatcher("/getById/{studentId}"),
                    new AntPathRequestMatcher("/v3/api-docs/**"),
                    new AntPathRequestMatcher("/swagger-ui/**"),
                    new AntPathRequestMatcher("/employeeController/**")
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

