package com.example.demo.demo.Repository;

import com.example.demo.demo.Model.User;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UserRepo extends MongoRepository<User,String> {
    User findByUserId(String userId);
    void deleteByUserId(String userId);
}
