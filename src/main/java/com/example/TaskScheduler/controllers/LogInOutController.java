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
public class LogInOutController {
    @GetMapping("/login")
    public String getLogin(Model model) {
        // Might be some logic or switch to simple <a> in html
        return "login";
    }
//    @PostMapping("/log-in")
//    public String login(@RequestParam String email,
//                        @RequestParam String password,
//                        Model model) {
//        //TODO:
//        // 1. somehow authenticate a user given an email and a password
//        // 2. add something to a model to enable retrieving appropriate tasks in home method
//        // 3. redirect to home
//
//        // TODO: I think here it should be an ultimate method for:
//        //  1. auto-log-in when session is available (called from StartController probably or something with SpringSecurity)
//        //  2. when a user signs up with a new account, retrieve the last record from a database and log in with these details
//        //  3. take data from a page and log in when user manually logs in
//
//        // TODO: here check : if account exists (all good) -> redirect home (with a user as a parameter to HomeController),
//        //  otherwise say somehow that wrong email or password
//        //  (I think there is no need to distinguish between wrong details and an account doesn't exist)
//        return "redirect:/home";
//    }
}
