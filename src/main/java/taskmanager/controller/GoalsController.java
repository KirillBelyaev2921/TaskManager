package taskmanager.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import taskmanager.model.TaskGoal;
import taskmanager.repository.TaskGoalRepository;
import taskmanager.repository.TaskRepository;

import java.time.LocalDate;

@Controller
@RequestMapping("/goal")
@AllArgsConstructor
public class GoalsController {

    private final TaskRepository taskRepository;
    private final TaskGoalRepository taskGoalRepository;

    @GetMapping
    public String goalsForDay(@ModelAttribute("newGoal") TaskGoal goal,
            @RequestParam(required = false) LocalDate date, Model model) {
        model.addAttribute("selectedDate", date == null ? LocalDate.now() : date);
        model.addAttribute("tasks", taskRepository.findAll());
        model.addAttribute("goals", taskGoalRepository.findAll());
        return "goals";
    }

    @PostMapping
    public String addGoal(@ModelAttribute("newGoal") TaskGoal goal) {
        taskGoalRepository.save(goal);
        return "redirect:/goal";
    }

}
