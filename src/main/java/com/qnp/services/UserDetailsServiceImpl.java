package com.qnp.services;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

     @Override
     public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
         UserDetails userDetails =
                 org.springframework.security.core.userdetails.User.builder()
                         .username("username@mail.com")
                         .password("password")
                         .build();
         return userDetails;
     }
 }