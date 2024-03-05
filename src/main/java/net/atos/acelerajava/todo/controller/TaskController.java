package net.atos.acelerajava.todo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.atos.acelerajava.todo.model.Task;
import net.atos.acelerajava.todo.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/tasks")
@Api(tags = "Task Controller")
public class TaskController {

    private final TaskService taskService;

    @Autowired
    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @ApiOperation(value = "Visualizar todas as tarefas", response = Iterable.class)
    @GetMapping
    public String showTasks(Model model) {
        Task task = TaskService.populate(model);
        model.addAttribute("task", task);
        model.addAttribute("tasks", this.taskService.getAllTasks());
        return "layout";
    }

    @ApiOperation(value = "Criar nova tarefa")
    @PostMapping("/save")
    public String saveTask(Task task) {
        this.taskService.createTask(task);
        return "redirect:/tasks";
    }

    @ApiOperation(value = "Editar tarefa por ID")
    @GetMapping("/edit/{id}")
    public String editTask(RedirectAttributes attributes, @PathVariable("id") Long id) {
        attributes.addFlashAttribute("taskForEdit", this.taskService.findTaskById(id));
        return "redirect:/tasks";
    }

    @ApiOperation(value = "Deletar tarefa por ID")
    @GetMapping("/delete/{id}")
    public String deleteTask(@PathVariable("id") Long id) {
        this.taskService.deleteTask(id);
        return "redirect:/tasks";
    }
}
