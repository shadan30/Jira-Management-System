package com.example.demo.demo.Controller;

import com.example.demo.demo.Model.Task;
import com.example.demo.demo.Service.SprintService;
import com.example.demo.demo.Service.UserService;
import com.example.demo.demo.dto.SprintDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sprint")
public class SprintController {

    @Autowired
    SprintService sprintService;
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String createSprint(@RequestBody SprintDTO sprintDTO){
        return sprintService.createSprint(sprintDTO);
    }

    @PutMapping("/add/{sprintId}")
    public String addTask(@PathVariable String sprintId,
                   @RequestParam String taskId){
        return sprintService.addTask(sprintId, taskId);
    }

    @DeleteMapping("/remove/{sprintId}")
    public String removeTask(@PathVariable String sprintId,
                             @RequestParam String taskId){
        return sprintService.removeTask(sprintId,taskId);
    }

    @GetMapping("/{sprintId}")
    public ResponseEntity<Page<Task>> getAllTasks(@PathVariable String sprintId,
                                                  @RequestParam(defaultValue = "0") int pageNo,
                                                  @RequestParam(defaultValue ="10") int pageSize) throws Exception {
        Page<Task> result = sprintService.getAllTasks(sprintId,pageNo,pageSize);
        return ResponseEntity.ok().body(result);
    }

}
