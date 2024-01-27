package com.example.TaskScheduler.controllers;
import com.example.TaskScheduler.models.Task;
import com.example.TaskScheduler.repo.TaskRepository;
import com.example.TaskScheduler.util.Tasks;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DoneController {
    @GetMapping("/done")
    public String done(Model model){
        Iterable<Task> tasks = MainController.getUser().getTasks();
        model.addAttribute("doneTasks", Tasks.doneTasks(tasks));
        model.addAttribute("activePage", "done");
        model.addAttribute("userName", MainController.getUser().getName());
        return "pages/done";
    }
}
