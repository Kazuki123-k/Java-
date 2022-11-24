package com.example.Mongodb.repository;

import com.example.Mongodb.model.Idea;
import com.example.Mongodb.resource.IdeaRequest;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

public interface IdeaRepository extends MongoRepository<Idea, String> {

    Optional<Idea> findByName(String name);

    String deleteByName(String name);


}
