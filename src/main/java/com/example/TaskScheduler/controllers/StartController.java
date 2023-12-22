package com.example.TaskScheduler.controllers;
import com.example.TaskScheduler.models.Task;
import com.example.TaskScheduler.models.User;
import com.example.TaskScheduler.repo.TaskRepository;
import com.example.TaskScheduler.repo.UserRepository;
import com.example.TaskScheduler.util.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;
import java.util.Optional;

@Controller
public class StartController {
    @Autowired
    private UserRepository userRepository;

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
    public String signup(@RequestParam String email,
                         @RequestParam String name,
                         @RequestParam String surname,
                         @RequestParam String password,
                         @RequestParam LocalDate dateOfBirth,
                         Model model) {
        if(userRepository.existsByEmail(email)){
            model.addAttribute("exists", true);
            return "sign-up";
        }
        User user = new User(email, name, surname, password, dateOfBirth);
        userRepository.save(user);
        // TODO: here you need to pass the control to LogInOutController
        //  to retrieve this last saved record in a database and log in
        //  into an account with these details
        // now it returns to home, change later
        return "redirect:/home";
    }
}
