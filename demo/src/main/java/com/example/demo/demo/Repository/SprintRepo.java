package com.example.demo.demo.Repository;

import com.example.demo.demo.Model.Sprint;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SprintRepo extends MongoRepository<Sprint,String> {
    Sprint findBySprintId(String sprintId);
}
