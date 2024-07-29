package taskmanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import taskmanager.model.ScheduledTask;
import taskmanager.repository.ScheduledTaskRepository;
import taskmanager.repository.TaskRepository;

import java.time.LocalDateTime;

@Controller
@AllArgsConstructor
@RequestMapping("/schedule")
public class ScheduledTaskController {

    private final TaskRepository taskRepository;
    private final ScheduledTaskRepository scheduledTaskRepository;

    @GetMapping
    public String getScheduledTasks(@ModelAttribute("newScheduledTask") ScheduledTask scheduledTask,
                                    Model model) {
        model.addAttribute("scheduledTasks", scheduledTaskRepository.findAll());
        model.addAttribute("tasks", taskRepository.findAll());
        return "schedule";
    }

    @PostMapping
    public String addScheduledTask(@ModelAttribute("newScheduledTask") ScheduledTask scheduledTask) {
        scheduledTask.setStartTime(LocalDateTime.now());
        scheduledTask.setEndTime(LocalDateTime.now());
        scheduledTaskRepository.save(scheduledTask);
        return "redirect:/schedule";
    }
}
