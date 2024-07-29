package taskmanager.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import taskmanager.model.ScheduledTask;

public interface ScheduledTaskRepository extends JpaRepository<ScheduledTask, Long> {
}