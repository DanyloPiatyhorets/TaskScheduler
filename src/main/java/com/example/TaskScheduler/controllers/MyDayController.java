package com.example.TaskScheduler.controllers;
import com.example.TaskScheduler.models.Task;
import com.example.TaskScheduler.repo.TaskRepository;
import com.example.TaskScheduler.util.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MyDayController {
    @Autowired
    private TaskRepository taskRepository;
    @GetMapping("/my-day")
    public String myday(Model model){
        Iterable<Task> tasks = taskRepository.findAll();
        model.addAttribute("firstPriorityTasks", Tasks.priorityTasks(tasks, 1));
        model.addAttribute("secondPriorityTasks", Tasks.priorityTasks(tasks, 2));
        model.addAttribute("thirdPriorityTasks", Tasks.priorityTasks(tasks, 3));
        model.addAttribute("activePage", "my-day");
        return "/my-day";
    }
}
