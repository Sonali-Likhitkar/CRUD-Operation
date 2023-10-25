package com.example.practice.practice.serviceimpl;

import com.example.practice.practice.constant.UserConstant;
import com.example.practice.practice.entity.Students;
import com.example.practice.practice.exception.UserException;
import com.example.practice.practice.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private StudentRepository studentRepository;

    public UserDetailsServiceImpl(StudentRepository repository) {
        this.studentRepository = repository;
    }

    /**
     * @param email
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String email) {
       Optional<Students> studentInfo= studentRepository.findByEmail(email);
//       System.out.println("Student Info ============>"+studentInfo.isEmpty());
        if(studentInfo.isEmpty())
        {
            throw new UserException(HttpStatus.UNAUTHORIZED,UserConstant.INVAILD_EMAIL_PASSWORD);
        }
         return new User(studentInfo.get().getEmail(),studentInfo.get().getPassword(),getAuthority(studentInfo.get()));
    }

    private Collection<? extends GrantedAuthority> getAuthority(Students students) {
        return null;
    }
//    private Set<SimpleGrantedAuthority> getAuthority(User user) {
//        Set<SimpleGrantedAuthority> authorities = new HashSet<>();
////        user.getRoles().forEach(role -> {
////            authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName()));
////        });
//        return authorities;
//    }
}
