package net.atos.acelerajava.todo.service;

import jakarta.transaction.Transactional;
import net.atos.acelerajava.todo.model.Task;
import net.atos.acelerajava.todo.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService implements ITask {

    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return (List<Task>) this.taskRepository.findAll();
    }

    @Override
    public Task findTaskById(Long id) {
        Optional<Task> optionalTask = this.taskRepository.findById(id);
        return optionalTask.orElse(null);
    }

    @Override
    public Task createTask(Task task) {
        return this.taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long id) {
        this.taskRepository.deleteById(id);
    }

    public static Task populate(Model model) {
        if (model.containsAttribute("taskForEdit")) {
            return (Task) model.getAttribute("taskForEdit");
        }
        return new Task();
    }
}
