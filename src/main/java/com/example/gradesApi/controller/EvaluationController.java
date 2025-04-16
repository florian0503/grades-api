package com.example.gradesApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.gradesApi.dto.EvaluationDTO;
import com.example.gradesApi.expectations.ResourceMissingException;
import com.example.gradesApi.model.Evaluation;
import com.example.gradesApi.model.Participant;
import com.example.gradesApi.model.Topic;
import com.example.gradesApi.repository.ParticipantRepository;
import com.example.gradesApi.repository.TopicRepository;
import com.example.gradesApi.service.EvaluationService;

@RestController
@RequestMapping("/evaluations")
public class EvaluationController {

    private final EvaluationService evaluationService;
    private final ParticipantRepository participantRepository;
    private final TopicRepository topicRepository;

    @Autowired
    public EvaluationController(EvaluationService evaluationService,
            ParticipantRepository participantRepository,
            TopicRepository topicRepository) {
        this.evaluationService = evaluationService;
        this.participantRepository = participantRepository;
        this.topicRepository = topicRepository;
    }

    @PostMapping
    public ResponseEntity<Evaluation> createEvaluation(@RequestBody EvaluationDTO dto) {
        Participant participant = participantRepository.findById(dto.getParticipantId())
                .orElseThrow(() -> new ResourceMissingException("Participant not found"));
        Topic topic = topicRepository.findById(dto.getTopicId())
                .orElseThrow(() -> new ResourceMissingException("Topic not found"));

        Evaluation eval = new Evaluation();
        eval.setParticipant(participant);
        eval.setTopic(topic);
        eval.setScore(dto.getScore());

        Evaluation saved = evaluationService.createEvaluation(eval);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Evaluation> updateEvaluation(@PathVariable Long id,
            @RequestBody EvaluationDTO dto) {
        Evaluation existing = evaluationService.retrieveEvaluationById(id);
        if (existing == null) {
            return ResponseEntity.notFound().build();
        }

        Participant participant = participantRepository.findById(dto.getParticipantId())
                .orElseThrow(() -> new ResourceMissingException("Participant not found"));
        Topic topic = topicRepository.findById(dto.getTopicId())
                .orElseThrow(() -> new ResourceMissingException("Topic not found"));

        existing.setParticipant(participant);
        existing.setTopic(topic);
        existing.setScore(dto.getScore());

        Evaluation updated = evaluationService.updateEvaluationById(id, existing);
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEvaluation(@PathVariable Long id) {
        evaluationService.deleteEvaluationById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/participant/{participantId}")
    public ResponseEntity<List<Evaluation>> fetchByParticipant(@PathVariable Long participantId) {
        List<Evaluation> list = evaluationService.getEvaluationsForLearner(participantId);
        return ResponseEntity.ok(list);
    }

    @GetMapping("/topic/{topicId}")
    public ResponseEntity<List<Evaluation>> fetchByTopic(@PathVariable Long topicId) {
        List<Evaluation> list = evaluationService.getEvaluationsForSubject(topicId);
        return ResponseEntity.ok(list);
    }
}
