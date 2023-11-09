package com.example.TaskScheduler.controllers;
import com.example.TaskScheduler.models.Task;
import com.example.TaskScheduler.repo.TaskRepository;
import com.example.TaskScheduler.util.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MissedController {
    @Autowired
    private TaskRepository taskRepository;
    @GetMapping("/missed")
    public String missed(Model model){
        Iterable<Task> tasks = taskRepository.findAll();
        model.addAttribute("missedTasks", Tasks.missedTasks(tasks));
        model.addAttribute("activePage", "missed");
        return "/missed";
    }
}
