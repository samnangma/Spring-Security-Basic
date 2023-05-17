package com.example.springsecurity.service;

import com.example.springsecurity.model.Account;
import com.example.springsecurity.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserServiceDetailsImpl implements UserDetailsService {

    // load user from the database
    // inject repository

    final private UserRepository userRepository;
    CustomUserServiceDetailsImpl(UserRepository userRepository){
        this.userRepository= userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Account user = userRepository.findUserByEmail(email);

        UserDetails userDetails = User.builder()
                .username(user.getEmail())
                .password(user.getPasscode())
                .roles(user.getRole())
                .build();

        System.out.println("here is the value of the userDetail : "+userDetails);
        return userDetails;
    }
}
