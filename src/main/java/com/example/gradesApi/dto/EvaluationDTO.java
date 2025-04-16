package com.example.gradesApi.dto;

public class EvaluationDTO {
    private Long participantId;
    private Long topicId;
    private double score;

    public EvaluationDTO() {
    }

    public EvaluationDTO(Long participantId, Long topicId, double score) {
        this.participantId = participantId;
        this.topicId = topicId;
        this.score = score;
    }

    public Long getParticipantId() {
        return participantId;
    }

    public void setParticipantId(Long participantId) {
        this.participantId = participantId;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }
}
