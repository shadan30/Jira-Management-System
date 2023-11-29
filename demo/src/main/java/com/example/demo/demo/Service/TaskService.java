package com.example.demo.demo.Service;

import com.example.demo.demo.Model.Task;
import com.example.demo.demo.dto.TaskDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

@Service
public interface TaskService {
    String addJira(TaskDTO taskDTO);
    String updateStatus(String taskId, String status);
    Page<Task> getTasks(String status, int pageNo, int pageSize);
    Page<Task> getDelayedTasks(int pageNo,int pageSize);
}
