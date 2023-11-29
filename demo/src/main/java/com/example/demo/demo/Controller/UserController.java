package com.example.demo.demo.Controller;

import com.example.demo.demo.Model.Task;
import com.example.demo.demo.Service.UserService;
import com.example.demo.demo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.bind.DefaultValue;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/add")
    public String addUser(@RequestBody UserDTO userDTO){
        return userService.addUser(userDTO);
    }

    @DeleteMapping("/{userId}")
    public String removeUser(@PathVariable String userId){
        return userService.removeUser(userId);
    }

    @GetMapping("/tasks/{userId}")
    public ResponseEntity<Page<Task>> getAllTasks(@PathVariable String userId,
                                                  @RequestParam(defaultValue = "0") int pageNo,
                                                  @RequestParam(defaultValue ="10") int pageSize) throws Exception {
        Page<Task> result = userService.getAllTasks(userId,pageNo,pageSize);
        return ResponseEntity.ok().body(result);
    }

}
