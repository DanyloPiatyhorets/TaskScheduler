package com.example.TaskScheduler.util;

import com.example.TaskScheduler.models.User;
import com.example.TaskScheduler.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;
//@Service
//public class CustomService implements UserDetailsService {
//// class to find users in a database (as I understood) using override method
//    @Autowired
//    private UserRepository userRepository;
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        Optional<User> user =  userRepository.findByEmail(username);
//        if(user.isEmpty()){
//            throw new UsernameNotFoundException("user not found");
//        }
//        return user.get();
//    }
//}
