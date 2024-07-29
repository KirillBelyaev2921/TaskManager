package taskmanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import taskmanager.model.Task;
import taskmanager.repository.TaskRepository;

@Controller
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {

    private final TaskRepository taskRepository;

    @GetMapping
    public String getTasks(@ModelAttribute("newTask") Task task, Model model) {
        model.addAttribute("tasks", taskRepository.findAll());
        return "tasks";
    }

    @PostMapping
    public String addTask(@ModelAttribute("newTask") Task task) {
        taskRepository.save(task);
        return "redirect:/tasks";
    }
}
