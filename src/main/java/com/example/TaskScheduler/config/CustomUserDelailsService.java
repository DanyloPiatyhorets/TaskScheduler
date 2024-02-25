package com.example.TaskScheduler.config;

import com.example.TaskScheduler.models.User;
import com.example.TaskScheduler.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Service
public class CustomUserDelailsService implements UserDetailsService {

    UserRepository userRepository;
    @Autowired
    public CustomUserDelailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(),
                getGrantedAuthorities());
    }
    // to be customised accordingly to roles if needed
    // roles can be fetched from user, so if more roles needed, a List<String> roles to be added in User (look for comments in User)
    private Collection<GrantedAuthority> getGrantedAuthorities(){
        Set<GrantedAuthority> authorities = new HashSet<>();
        authorities.add(new SimpleGrantedAuthority("USER"));
        return authorities;
    }
}
