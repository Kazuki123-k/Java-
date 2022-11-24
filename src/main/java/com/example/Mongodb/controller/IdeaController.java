package com.example.Mongodb.controller;

import com.example.Mongodb.model.Idea;
import com.example.Mongodb.repository.IdeaRepository;
import com.example.Mongodb.resource.IdeaRequest;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/idea")
    public ResponseEntity<List<Idea>> getAllIdeas() {
        return ResponseEntity.ok(this.ideaRepository.findAll());
    }

    @GetMapping("/idea/{name}")
    public Optional<Idea> getByName(@PathVariable final String name) {
        return ideaRepository.findByName(name);
    }

    @PostMapping("/idea")
    public ResponseEntity<Idea> createIdea(@RequestBody IdeaRequest ideaRequest) {
        Idea idea = new Idea();

        idea.setName(ideaRequest.getName());
        idea.setTopic(ideaRequest.getTopic());
        idea.setDescription(ideaRequest.getDescription());

        return ResponseEntity.status(201).body(this.ideaRepository.save(idea));

    }

//    @PutMapping(path="idea/{name}")
//    public Idea updateIdea(@PathVariable String name, @RequestBody IdeaRequest ideaRequest) {
//        return ideaRepository.updateIdeaTopic(ideaRequest).getBody();
//    }

    @DeleteMapping(value="idea/{name}")
    public String deleteByName(@PathVariable final String name) {
        return ideaRepository.deleteByName(name);
    }
}
