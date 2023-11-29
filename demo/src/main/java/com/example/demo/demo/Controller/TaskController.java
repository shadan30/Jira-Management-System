package com.example.demo.demo.Controller;

import com.example.demo.demo.Model.Task;
import com.example.demo.demo.Service.TaskService;
import com.example.demo.demo.dto.TaskDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/jira")
public class TaskController {
    @Autowired
    TaskService taskService;

    @PostMapping("/add")
    public String addJira(@RequestBody TaskDTO taskDTO){
        return taskService.addJira(taskDTO);
    }

    @PutMapping("/status")
    public String updateStatus(@RequestParam("taskId") String taskId,
                               @RequestParam("status") String status){
        return taskService.updateStatus(taskId,status);
    }

    @GetMapping("/task/{status}")
    public ResponseEntity<Page<Task>> getTaskByStatus(@PathVariable("status") String status,
                                                      @RequestParam(defaultValue = "0") int pageNo,
                                                      @RequestParam(defaultValue ="10") int pageSize){
        Page<Task> tasks = taskService.getTasks(status,pageNo,pageSize);
        return ResponseEntity.ok().body(tasks);
    }

    @GetMapping("/task/delayed")
    public ResponseEntity<Page<Task>> getDelayedTask(@RequestParam(defaultValue = "0") int pageNo,
                                                      @RequestParam(defaultValue ="10") int pageSize){
        Page<Task> tasks = taskService.getDelayedTasks(pageNo,pageSize);
        return ResponseEntity.ok().body(tasks);
    }

}
