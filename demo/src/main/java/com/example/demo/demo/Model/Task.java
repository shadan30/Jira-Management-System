package com.example.demo.demo.Model;

import com.example.demo.demo.dto.TaskDTO;
import com.example.demo.demo.enums.TaskStatus;
import com.example.demo.demo.enums.TaskType;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Document(collection = "Tasks")
public class Task {
    @Id
    private String id;
    private String taskId;
    private TaskType taskType; //task type - story, feature, bugs (stories can have further subtracts)
    private TaskStatus taskStatus; // OPEN,IN_PROGRESS,PROD_READY,CLOSED,BLOCKED
    private String title;
    private String description;
    private String createdBy;
    private String assignedTo;
    private LocalDate endDate;
    @CreatedDate
    private LocalDate createdAt;
    @LastModifiedDate
    private LocalDateTime lastUpdatedAt;

    public Task() {
    }

    public Task(TaskDTO taskDTO,User createdBy,User assignedTo) {
        this.taskId= taskDTO.getTaskId();
        this.taskType=TaskType.valueOf(taskDTO.getTaskType().toUpperCase());
        this.taskStatus=TaskStatus.valueOf(taskDTO.getTaskStatus().toUpperCase());
        this.title=taskDTO.getTitle();
        this.description=taskDTO.getDescription();
        this.createdBy=createdBy.getName();
        this.assignedTo=assignedTo.getName();
        this.endDate=taskDTO.getEndDate();
        this.createdAt=LocalDate.now();
        this.lastUpdatedAt=LocalDateTime.now();
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setTaskId(String taskId) {
        this.taskId = taskId;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
    }

    public void setTaskStatus(TaskStatus taskStatus) {
        this.taskStatus = taskStatus;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public void setLastUpdatedAt(LocalDateTime lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }

    public String getId() {
        return id;
    }

    public String getTaskId() {
        return taskId;
    }

    public TaskType getTaskType() {
        return taskType;
    }

    public TaskStatus getTaskStatus() {
        return taskStatus;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getLastUpdatedAt() {
        return lastUpdatedAt;
    }
}
