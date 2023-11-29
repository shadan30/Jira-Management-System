package com.example.demo.demo.Repository;

import com.example.demo.demo.Model.Task;
import com.example.demo.demo.enums.TaskStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface TaskRepo extends MongoRepository<Task,String> {
    Task findByTaskId(String taskId);
    Page<Task> findByTaskStatus(TaskStatus status, Pageable pageable);
    Page<Task> findByEndDateBefore(LocalDate currentDate,Pageable pageable);
    Page<Task> findByTaskIdIn(List<String> taskIds,Pageable pageable);
    Page<Task> findByAssignedTo(String assignedTo,Pageable pageable);
}
