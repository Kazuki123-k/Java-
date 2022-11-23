package com.example.Mongodb.repository;

import com.example.Mongodb.model.Idea;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IdeaRepository extends MongoRepository<Idea, String> {
//    public findByName(String name);
}
