package com.example.demo.demo.Service.Impl;

import com.example.demo.demo.Model.Sprint;
import com.example.demo.demo.Model.Task;
import com.example.demo.demo.Model.User;
import com.example.demo.demo.Repository.SprintRepo;
import com.example.demo.demo.Repository.TaskRepo;
import com.example.demo.demo.Repository.UserRepo;
import com.example.demo.demo.Service.SprintService;
import com.example.demo.demo.dto.SprintDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
public class SprintServiceImpl implements SprintService {
    @Autowired
    SprintRepo sprintRepo;
    @Autowired
    TaskRepo taskRepo;
    @Autowired
    UserRepo userRepo;
    public String createSprint(SprintDTO sprintDTO){
        User user = userRepo.findByUserId(sprintDTO.getCreatedBy());
        if(Objects.isNull(user)){
            return "Invalid User";
        }
        Sprint sprint = new Sprint(sprintDTO,user);
        sprintRepo.save(sprint);
        return "Sprint Added Successfully";
    }

    public String addTask(String sprintId, String taskId){
        Sprint sprint= sprintRepo.findBySprintId(sprintId);
        if(Objects.isNull(sprint))
            return "Sprint does not exist with given Id";
        Task task = taskRepo.findByTaskId(taskId);
        if(Objects.isNull(task))
            return "Task does not exist with given";
        List<String> taskList = sprint.getTaskIds();
        taskList.add(taskId);
        sprint.setTaskIds(taskList);
        sprintRepo.save(sprint);
        return "Task Added to Sprint";
    }

    public String removeTask(String sprintId,String taskId){
        Sprint sprint= sprintRepo.findBySprintId(sprintId);
        if(Objects.isNull(sprint))
            return "Sprint does not exist with given Id";
        if(!sprint.getTaskIds().contains(taskId))
            return "Task is not present in given sprint";
        List<String> taskList = sprint.getTaskIds();
        taskList.remove(taskId);
        sprint.setTaskIds(taskList);
        sprintRepo.save(sprint);
        return "Task Removed to Sprint";
    }

    public Page<Task> getAllTasks(String sprintId,int pageNo, int pageSize) throws Exception {
        Sprint sprint= sprintRepo.findBySprintId(sprintId);
        if(Objects.isNull(sprint))
            throw new Exception("Sprint With Given id is not present");
        List<String> taskIds = sprint.getTaskIds();
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return taskRepo.findByTaskIdIn(taskIds,pageable);
    }
}
