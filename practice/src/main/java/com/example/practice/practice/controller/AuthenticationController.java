package com.example.practice.practice.controller;

import com.example.practice.practice.constant.UserConstant;
import com.example.practice.practice.dto.JwtRequestDto;
import com.example.practice.practice.dto.JwtResponseDto;
import com.example.practice.practice.exception.UserException;
import com.example.practice.practice.security.JwtHelper;
import com.example.practice.practice.serviceimpl.UserDetailsServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

@RestController
//@RequestMapping("/api/V1")
public class AuthenticationController {

    @Autowired
    private UserDetailsServiceImpl userDetailsServiceImpl;

    @Autowired
    private AuthenticationManager authenticationManager;
    @Autowired
    private JwtHelper jwtHelper;
    private final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

    @GetMapping("/hey")
    public String Varchar() {
        return "hello this is string";
    }


@PostMapping("/login")
       public ResponseEntity<JwtResponseDto> loginApi(@RequestBody JwtRequestDto jwtRequestDto){
        try{
            this.authenticate(jwtRequestDto.getEmail(),jwtRequestDto.getPassword());

        }catch(Exception e){
            throw  new UserException(HttpStatus.NOT_FOUND,UserConstant.EMAIL_NOT_FOUND);
    }
        UserDetails userDetails =this.userDetailsServiceImpl.loadUserByUsername(jwtRequestDto.getEmail());
        String token= this.jwtHelper.generateToken(userDetails);
        return  ResponseEntity.ok(JwtResponseDto.builder().Token(token).build());
}


private  void authenticate( String email,String password){
        try{
        this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email,password));
}catch(DisabledException e){
            throw new UserException(HttpStatus.NOT_FOUND,UserConstant.USER_DISABLE);

        } catch (Exception e){
            throw new UserException(HttpStatus.BAD_REQUEST,UserConstant.INVALID_CREDENTIAL);
        }

    }












//    @PostMapping(value = "/login", produces = MediaType.APPLICATION_JSON_VALUE)
//        public ResponseEntity<JwtResponseDto> loginApi(@RequestBody JwtRequestDto jwtRequest) {
//        System.out.println(" login api  ..................... !!!! ");
//        try {
//            this.authenticate(jwtRequest.getEmail(), jwtRequest.getPassword());
//            LOGGER.info("Authentication successful for email: {}", jwtRequest.getEmail());
//        } catch (Exception e) {
//            e.printStackTrace();
//            LOGGER.error("Authentication failed for email: {}", e.getMessage());
//            throw new UserException(HttpStatus.NOT_FOUND, UserConstant.EMAIL_NOT_FOUND);
//        }
//        UserDetails userDetails = this.userDetailsServiceImpl.loadUserByUsername(jwtRequest.getEmail());
//        String token = this.jwtHelper.generateToken(userDetails);
//        LOGGER.info("Login successful for email: {}", jwtRequest.getEmail());
//        return ResponseEntity.ok( JwtResponseDto.builder().Token(token).build());
//    }
//
//
//    private void authenticate(String email, String password) {
//        try {
//            this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(email, password));
//        } catch (DisabledException e) {
//            LOGGER.error("User authentication failed due to DisabledException. Email: {}", e.getMessage());
//            throw new UserException(HttpStatus.NOT_FOUND,UserConstant.USER_DISABLE);
//        } catch (Exception e) {
//            LOGGER.error("User authentication failed due to Exception. Email: {}", e.getMessage());
//            throw new UserException(HttpStatus.BAD_REQUEST,UserConstant.INVALID_CREDENTIAL);
//        }
//    }


}