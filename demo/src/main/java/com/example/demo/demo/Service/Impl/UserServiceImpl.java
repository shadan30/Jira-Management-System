package com.example.demo.demo.Service.Impl;

import com.example.demo.demo.Model.Task;
import com.example.demo.demo.Model.User;
import com.example.demo.demo.Repository.TaskRepo;
import com.example.demo.demo.Repository.UserRepo;
import com.example.demo.demo.Service.UserService;
import com.example.demo.demo.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;
    @Autowired
    TaskRepo taskRepo;
    public String addUser(UserDTO userDTO){
        User user = new User(userDTO);
        userRepo.save(user);
        return "User added successfully";
    }

    public String removeUser(String userId){
        User user = userRepo.findByUserId(userId);
        if(Objects.isNull(user))
            return "User not Present in Data Base";
        userRepo.deleteByUserId(userId);
        return "User removed successfully";
    }

    public Page<Task> getAllTasks(String userId,int pageNo, int pageSize) throws Exception {
        User user = userRepo.findByUserId(userId);
        if(Objects.isNull(user))
            throw new Exception("User does nor exist");
        Pageable pageable = PageRequest.of(pageNo,pageSize);
        return taskRepo.findByAssignedTo(user.getName(),pageable);
    }
}
