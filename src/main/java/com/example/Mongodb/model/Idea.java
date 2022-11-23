package com.example.Mongodb.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("ideas")
public class Idea {

    @Id
    private String id;
    private String name;
    private String topic;
    private String description;

    public Idea() {

    }

    public Idea(String name, String topic, String description) {
        this.name = name;
        this.topic = topic;
        this.description = description;
    }

    public String findByName(String name) {
         if(this.name == name) {
             return name;
         }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getTopic() {
        return topic;
    }

    public String getDescription() {
        return description;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTopic(String topic) {
        this.topic = topic;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
