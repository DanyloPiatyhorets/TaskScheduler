package com.example.TaskScheduler.controllers;
import com.example.TaskScheduler.config.CustomUserDelailsService;
import com.example.TaskScheduler.models.User;
import com.example.TaskScheduler.repo.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
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

    private final CustomUserDelailsService customUserDelailsService;

    @Autowired
    public AuthenticationController(AuthenticationManager authenticationManager,
                                    UserRepository userRepository,
                                    PasswordEncoder passwordEncoder,
                                    CustomUserDelailsService customUserDelailsService) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.customUserDelailsService = customUserDelailsService;
    }

    @GetMapping("/TaskScheduler")
    public String start(Model model) {
//        TODO: here you can try to check whether context holder is not empty.
//         If not - redirect it to home or whatever
        return "authentication/start";
    }
    @GetMapping("/sign-up")
    public String getSignup(Model model) {
        return "authentication/sign-up";
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
            return "authentication/sign-up";
        }
        User user = new User(username, name, surname,
                passwordEncoder.encode(password), dateOfBirth);
        userRepository.save(user);
//        TODO: think about automatic log in after signing up

//        UserDetails userDetails = customUserDelailsService.loadUserByUsername(user.getUsername());
//        Authentication authentication = new UsernamePasswordAuthenticationToken(
//                userDetails, null, userDetails.getAuthorities());
//        SecurityContextHolder.getContext().setAuthentication(authentication);

        return "redirect:/log-in";
    }
    @GetMapping("/log-in")
    public String getLogin(Model model) {
        return "authentication/log-in";
    }

//    @PostMapping("/log-in")
//    public String login(@RequestParam String username,
//                        @RequestParam String password,
//                        RedirectAttributes redirectAttributes,
//                        Model model){
//        Authentication authentication = authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(username, password));
//        SecurityContextHolder.getContext().setAuthentication(authentication);
//        return "redirect:/home";
//    }
}
