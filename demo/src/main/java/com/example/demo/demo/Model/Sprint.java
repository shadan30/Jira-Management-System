package com.example.demo.demo.Model;

import com.example.demo.demo.dto.SprintDTO;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "Sprints")
public class Sprint {
    @Id
    private String id;
    private String sprintId;
    private List<String> taskIds;
    private String createdBy;
    private LocalDate endDate;
    @CreatedDate
    private LocalDate createdAt;
    @LastModifiedDate
    private LocalDateTime lastUpdatedAt;

    public Sprint() {
    }

    public Sprint(SprintDTO sprintDTO,User user) {
        this.sprintId=sprintDTO.getSprintId();
        this.taskIds=sprintDTO.getTaskIds();
        this.createdBy=user.getName();
        this.endDate=sprintDTO.getEndDate();
        this.createdAt=LocalDate.now();
        this.lastUpdatedAt=LocalDateTime.now();
    }

    public String getSprintId() {
        return sprintId;
    }

    public void setSprintId(String sprintId) {
        this.sprintId = sprintId;
    }

    public List<String> getTaskIds() {
        return taskIds;
    }

    public void setTaskIds(List<String> taskIds) {
        this.taskIds = taskIds;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public LocalDate getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDate createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getLastUpdatedAt() {
        return lastUpdatedAt;
    }

    public void setLastUpdatedAt(LocalDateTime lastUpdatedAt) {
        this.lastUpdatedAt = lastUpdatedAt;
    }
}
