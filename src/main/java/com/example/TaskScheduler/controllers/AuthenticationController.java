package com.example.TaskScheduler.controllers;
import com.example.TaskScheduler.models.User;
import com.example.TaskScheduler.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Controller
public class AuthenticationController {
    private final AuthenticationManager authenticationManager;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager,
                                    UserRepository userRepository,
                                    PasswordEncoder passwordEncoder) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/TaskScheduler")
    public String start(Model model) {
        // TODO: Here the logic to check whether there's an available session
        // and a user can be logged in automatically
        // if so -> return home (logged in)
        // else -> return start
        return "start";
    }
    @GetMapping("/sign-up")
    public String getSignup(Model model) {
        // Might be some logic or switch to simple <a> in html
        return "sign-up";
    }
    @PostMapping("/sign-up")
    public String signup(@RequestParam String username,
                         @RequestParam String name,
                         @RequestParam String surname,
                         @RequestParam String password,
                         @RequestParam LocalDate dateOfBirth,
                         Model model) {
        if(userRepository.existsByUsername(username)){
            model.addAttribute("exists", true);
            return "sign-up";
        }
        User user = new User(username, name, surname,
                passwordEncoder.encode(password), dateOfBirth);
        userRepository.save(user);
        // TODO: here you need to pass the control to /login with username and password as parameters
        // now it returns to home, change later
        return "redirect:/TaskScheduler";
    }
    @PostMapping("/login")
    public String login(@RequestParam String username,
                        @RequestParam String password){
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));
        SecurityContextHolder.getContext().setAuthentication(authentication);
        return "redirect:/home";
    }
}
