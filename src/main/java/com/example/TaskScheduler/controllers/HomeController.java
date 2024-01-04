// планую внести зміни для контролера для налаштування мов
// в разі чого просто видалити поля, існуюча система змінюватися не буде

package com.example.TaskScheduler.controllers;

import com.example.TaskScheduler.models.Task;
import com.example.TaskScheduler.repo.TaskRepository;
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
public class HomeController {
    @Autowired
    private TaskRepository taskRepository;

    @GetMapping("/home")
    public String home(Model model) {
        // TODO: change it here to get only particular tasks for a user
        //(probably it is fair for all methods here, have a think)
        // at least same for all controllers
        Iterable<Task> tasks = taskRepository.findAll();
        model.addAttribute("todayTasks", Tasks.todayTasks(tasks));
        model.addAttribute("laterTasks", Tasks.laterTasks(tasks));
        model.addAttribute("activePage", "home");
        return "/home";
    }
    @GetMapping("/home/add")
    public String taskAdd(Model model){
        return "actions/task-add";
    }

    @PostMapping("home/add")
    public String taskPostAdd(@RequestParam String name,
                              @RequestParam LocalDate deadline,
                              @RequestParam int priority,
                              @RequestParam String note,
                              Model model){
        Task task = new Task(name, deadline, priority, note);
        taskRepository.save(task);
        return "redirect:/home";
    }
    @GetMapping("/home/{id}")
    public String taskUpdate(@PathVariable(value = "id") long id,
                             Model model){
        Optional<Task> task = taskRepository.findById(id);
        if (task.isEmpty())
            return "redirect:/home";
        model.addAttribute("task", task.get());
        return "actions/task-update";
    }
    @PostMapping("home/{id}")
    public String taskPostUpdate(@PathVariable(value = "id") long id,
                                 @RequestParam String name,
                                 @RequestParam LocalDate deadline,
                                 @RequestParam int priority,
                                 @RequestParam String note,
                                 Model model){
        Task task = taskRepository.findById(id).orElseThrow();
        task.setName(name);
        task.setDeadline(deadline);
        task.setPriority(priority);
        task.setNote(note);
        taskRepository.save(task);
        return "redirect:/home";
    }
    @PostMapping("home/{id}/delete")
    public String taskPostDelete(@PathVariable(value = "id") long id,
                                 Model model){
        Task task = taskRepository.findById(id).orElseThrow();
        taskRepository.delete(task);
        return "redirect:/home";
    }
    @PostMapping("home/{id}/complete")
    public String taskPostComplete(@PathVariable(value = "id") long id,
                                 Model model){
        Task task = taskRepository.findById(id).orElseThrow();
        task.setDone(true);
        taskRepository.save(task);
        return "redirect:/home";
    }
}

