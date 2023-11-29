package com.example.demo.demo.dto;

import lombok.Data;

import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.List;

@Data
public class SprintDTO {
    @NotNull
    private String sprintId;
    private List<String> taskIds;
    private String createdBy;
    private LocalDate endDate;

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
}
