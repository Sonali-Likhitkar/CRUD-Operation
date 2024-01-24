package com.example.practice.practice.serviceimpl;

import com.example.practice.practice.constant.UserConstant;
import com.example.practice.practice.entity.User;
import com.example.practice.practice.exception.UserException;
import com.example.practice.practice.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;

    public UserDetailsServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * @param email
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) {
        System.out.println("Inside the user details service impl load by user name======"+email);
        User userInfo= userRepository.findByEmail(email);
        if(userInfo == null)
        {
            throw new UserException(HttpStatus.UNAUTHORIZED,UserConstant.INVAILD_EMAIL_PASSWORD);
        }
         return new org.springframework.security.core.userdetails.User(userInfo.getEmail(),userInfo.getPassword(),Collections.emptySet());
    }

//    private Collection<? extends GrantedAuthority> getAuthority(com.example.practice.practice.entity.User user) {
//        return null;
//    }
//    private Set<SimpleGrantedAuthority> getAuthority(User user) {
//        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
////        user.getRoles().forEach(role -> {
////            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
////        });
//        return authorities;
//    }
}
