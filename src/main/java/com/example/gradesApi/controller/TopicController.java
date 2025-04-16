package com.example.gradesApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.gradesApi.model.Topic;
import com.example.gradesApi.service.TopicService;

@RestController
@RequestMapping("/topics")
public class TopicController {

    private final TopicService topicService;

    @Autowired
    public TopicController(TopicService topicService) {
        this.topicService = topicService;
    }

    @PostMapping
    public ResponseEntity<Topic> createTopic(@RequestBody Topic topic) {
        Topic saved = topicService.addTopic(topic);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{topicId}")
    public ResponseEntity<Topic> updateTopic(@PathVariable("topicId") Long id,
            @RequestBody Topic details) {
        Topic updated = topicService.updateTopic(id, details);
        return (updated != null)
                ? ResponseEntity.ok(updated)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @DeleteMapping("/{topicId}")
    public ResponseEntity<Void> deleteTopic(@PathVariable("topicId") Long id) {
        topicService.deleteTopic(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{topicId}")
    public ResponseEntity<Topic> getTopic(@PathVariable("topicId") Long id) {
        Topic topic = topicService.getTopicById(id);
        return (topic != null)
                ? ResponseEntity.ok(topic)
                : ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }

    @GetMapping
    public ResponseEntity<List<Topic>> listAllTopics() {
        List<Topic> all = topicService.getAllTopics();
        return ResponseEntity.ok(all);
    }
}
