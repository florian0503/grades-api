package com.example.gradesApi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.gradesApi.model.Participant;

@Repository
public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    Participant findByEmail(String email);
}
