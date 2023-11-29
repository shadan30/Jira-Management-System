package com.example.demo.demo.Service;

import com.example.demo.demo.Model.Task;
import com.example.demo.demo.dto.SprintDTO;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface SprintService {
    String createSprint(SprintDTO sprintDTO);
    String addTask(String sprintId, String taskId);
    String removeTask(String sprintId,String taskId);
    Page<Task> getAllTasks(String sprintId,int pageNo, int pageSize) throws Exception;
}
