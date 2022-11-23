package com.example.Mongodb.controller;

import com.example.Mongodb.model.Idea;
import com.example.Mongodb.repository.IdeaRepository;
import com.example.Mongodb.resource.IdeaRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class IdeaController {

    private final IdeaRepository ideaRepository;

    public IdeaController(IdeaRepository ideaRepository) {
        this.ideaRepository = ideaRepository;
    }

    @GetMapping("/idea/{name}")
    public ResponseEntity<List<Idea>> getIdeaByName(@PathVariable String name) {
        Optional<Idea> idea = this.ideaRepository.findByName(name);

        if(idea.isPresent()) {
            return ResponseEntity.ok(this.ideaRepository.get());
        } else {
            return ResponseEntity.ok("The user " + name + "has not written an idea yet :(");
        }

        return ResponseEntity.ok(this.ideaRepository.findAll());
    }

    @PostMapping("/idea")
    public ResponseEntity<Idea> createIdea(@RequestBody IdeaRequest ideaRequest) {
        Idea idea = new Idea();

        idea.setName(ideaRequest.getName());
        idea.setTopic(ideaRequest.getTopic());
        idea.setDescription(ideaRequest.getDescription());

        return ResponseEntity.status(201).body(this.ideaRepository.save(idea));

    }
}
