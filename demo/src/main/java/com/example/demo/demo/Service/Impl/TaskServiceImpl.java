package com.example.demo.demo.Service.Impl;

import com.example.demo.demo.Model.Task;
import com.example.demo.demo.Model.User;
import com.example.demo.demo.Repository.TaskRepo;
import com.example.demo.demo.Repository.UserRepo;
import com.example.demo.demo.Service.TaskService;
import com.example.demo.demo.dto.TaskDTO;
import com.example.demo.demo.enums.TaskStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Component
public class TaskServiceImpl implements TaskService {

    @Autowired
    TaskRepo taskRepo;
    @Autowired
    UserRepo userRepo;

    public String addJira(TaskDTO taskDTO){
        //Check is user is in system
        User createdBy=userRepo.findByUserId(taskDTO.getCreatedBy());
        if(Objects.isNull(createdBy)){
            return "Invalid User Creating Jira";
        }
        User assignedTo=userRepo.findByUserId(taskDTO.getAssignedTo());
        if(Objects.isNull(assignedTo)){
            return "Invalid User Being Assigned Jira To";
        }
        Task task=new Task(taskDTO,createdBy,assignedTo);
        taskRepo.save(task);
        return "Added Successfully";
    }

    public String updateStatus(String taskId,String status){
        TaskStatus taskStatus = TaskStatus.valueOf(status.toUpperCase());
        Task task = taskRepo.findByTaskId(taskId);
        if(task != null && !validStatusChange(task.getTaskStatus(),taskStatus)){
            return "Invalid Task Status Update";
        }
        if (task != null) {
            task.setTaskStatus(taskStatus);
            taskRepo.save(task);
        } else {
            return "Task not found with given Task Id";
        }
        return "Status Updated Successfully";
    }

    public Page<Task> getTasks(String status, int pageNo, int pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return taskRepo.findByTaskStatus(TaskStatus.valueOf(status.toUpperCase()), pageable);
    }

    public Page<Task> getDelayedTasks(int pageNo,int pageSize){
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        LocalDate currentDate = LocalDate.now().plusMonths(1);
        Page<Task> tasks = taskRepo.findByEndDateBefore(currentDate,pageable);
        List<Task> tasksList = tasks.stream()
                .filter(task -> !task.getTaskStatus().equals(TaskStatus.DONE))
                .toList();
        return new PageImpl<>(tasksList, pageable, tasksList.size());
    }

    private boolean validStatusChange(TaskStatus taskStatus, TaskStatus toStatus){
        if(TaskStatus.TO_DO.equals(taskStatus) && TaskStatus.DEV_IN_PROGRESS.equals(toStatus))
            return true;
        else if(TaskStatus.DEV_IN_PROGRESS.equals(taskStatus) && TaskStatus.DONE.equals(toStatus))
            return true;
        else if(TaskStatus.DEV_IN_PROGRESS.equals(taskStatus) && TaskStatus.TO_DO.equals(toStatus))
            return true;
        return false;
    }
}
