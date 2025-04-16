package com.example.gradesApi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gradesApi.repository.EvaluationRepository;

@Service
public class SummaryService {

    private final EvaluationRepository evalRepo;

    @Autowired
    public SummaryService(EvaluationRepository evaluationRepository) {
        this.evalRepo = evaluationRepository;
    }

    // controller.createTopicSummary(...)
    public String createTopicSummary(Long topicId) {
        double avg = evalRepo.findAverageScoreBySubject(topicId);
        return "Moyenne des scores pour le topic " + topicId + " : " + avg;
    }

    // controller.createParticipantSummary(...)
    public String createParticipantSummary(Long participantId) {
        double avg = evalRepo.findAverageScoreByLearner(participantId);
        return "Moyenne des scores pour le participant " + participantId + " : " + avg;
    }
}
