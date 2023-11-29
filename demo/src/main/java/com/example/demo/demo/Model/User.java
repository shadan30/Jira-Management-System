package com.example.demo.demo.Model;

import com.example.demo.demo.dto.UserDTO;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("Users")
public class User {
    @Id
    private String id;
    private String userId;
    private String name;
    private String email;

    public User() {
    }

    public User(UserDTO userDTO){
        this.userId = userDTO.getUserId();
        this.name = userDTO.getName();
        this.email = userDTO.getEmail();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
