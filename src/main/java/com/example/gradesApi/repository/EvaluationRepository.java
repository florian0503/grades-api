package com.example.gradesApi.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.gradesApi.model.Evaluation;

@Repository
public interface EvaluationRepository extends JpaRepository<Evaluation, Long> {

    /**
     * 
     * @param participantId l’ID du participant
     * @return liste des évaluations
     */
    List<Evaluation> findByParticipantId(Long participantId);

    /**
     * 
     * @param topicId l’ID du topic
     * @return liste des évaluations
     */
    List<Evaluation> findByTopicId(Long topicId);

    /**
     * 
     * @param topicId l’ID du topic
     * @return moyenne des scores
     */
    @Query("SELECT AVG(e.score) FROM Evaluation e WHERE e.topic.id = :topicId")
    double findAverageScoreBySubject(Long topicId);

    /**
     * 
     * @param participantId l’ID du participant
     * @return moyenne des scores
     */
    @Query("SELECT AVG(e.score) FROM Evaluation e WHERE e.participant.id = :participantId")
    double findAverageScoreByLearner(Long participantId);
}
