package com.example.demo.demo.Service;

import com.example.demo.demo.Model.Task;
import com.example.demo.demo.dto.UserDTO;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    String addUser(UserDTO userDTO);
    String removeUser(String userId);
    Page<Task> getAllTasks(String userId,int pageNo, int pageSize) throws Exception;
}
