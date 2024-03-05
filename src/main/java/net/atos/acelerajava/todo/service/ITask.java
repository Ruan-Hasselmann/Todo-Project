package net.atos.acelerajava.todo.service;

import net.atos.acelerajava.todo.model.Task;

import java.util.List;

public interface ITask {

    List<Task> getAllTasks();

    Task findTaskById(Long id);

    Task createTask(Task task);

    void deleteTask(Long id);
}
