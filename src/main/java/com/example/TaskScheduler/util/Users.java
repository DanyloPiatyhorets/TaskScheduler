package com.example.TaskScheduler.util;

import com.example.TaskScheduler.models.User;
import com.example.TaskScheduler.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

import java.util.Optional;

// utility class if nedeed
//@Service
@Service
public class Users {

//    @Autowired
//    private static UserRepository userRepository;
//    public static User getUser(UserRepository userRepository){
//        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
//        String username = authentication.getName();
//        Optional<User> user = userRepository.findByUsername(username);
//        if(user.isPresent()){
//            return user.get();
//        }
//        else throw new UsernameNotFoundException("bad");
//    }
}
