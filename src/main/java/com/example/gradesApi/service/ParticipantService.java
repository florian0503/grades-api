package com.example.gradesApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gradesApi.model.Participant;
import com.example.gradesApi.repository.ParticipantRepository;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepo;

    @Autowired
    public ParticipantService(ParticipantRepository participantRepository) {
        this.participantRepo = participantRepository;
    }

    // controller.addParticipant(...)
    public Participant addParticipant(Participant participant) {
        return participantRepo.save(participant);
    }

    // controller.updateParticipant(...)
    public Participant updateParticipant(Long id, Participant details) {
        Optional<Participant> opt = participantRepo.findById(id);
        if (opt.isPresent()) {
            Participant existing = opt.get();
            existing.setName(details.getName());
            existing.setEmail(details.getEmail());
            return participantRepo.save(existing);
        }
        return null;
    }

    // controller.deleteParticipant(...)
    public void deleteParticipant(Long id) {
        participantRepo.deleteById(id);
    }

    // controller.getParticipantById(...)
    public Participant getParticipantById(Long id) {
        return participantRepo.findById(id).orElse(null);
    }

    // controller.getAllParticipants()
    public List<Participant> getAllParticipants() {
        return participantRepo.findAll();
    }

    // si tu l’utilises quelque part
    public Participant findByEmail(String email) {
        return participantRepo.findByEmail(email);
    }
}
