package com.example.gradesApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.gradesApi.service.SummaryService;
import com.example.gradesApi.model.Topic;
import com.example.gradesApi.model.Participant;

@RestController
@RequestMapping("/summaries")
public class SummaryController {

    private final SummaryService summaryService;

    @Autowired
    public SummaryController(SummaryService summaryService) {
        this.summaryService = summaryService;
    }

    @GetMapping("/topic/{topicId}")
    public String produceTopicSummary(@PathVariable Long topicId) {
        return summaryService.createTopicSummary(topicId);
    }

    @GetMapping("/participant/{participantId}")
    public String produceParticipantSummary(@PathVariable Long participantId) {
        return summaryService.createParticipantSummary(participantId);
    }
}
