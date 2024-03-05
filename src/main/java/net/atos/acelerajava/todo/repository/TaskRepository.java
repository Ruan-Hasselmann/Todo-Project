package net.atos.acelerajava.todo.repository;

import net.atos.acelerajava.todo.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.ui.Model;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
