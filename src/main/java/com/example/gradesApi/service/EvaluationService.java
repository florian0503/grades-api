package com.example.gradesApi.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.gradesApi.model.Evaluation;
import com.example.gradesApi.repository.EvaluationRepository;

@Service
public class EvaluationService {

    private final EvaluationRepository evalRepo;

    @Autowired
    public EvaluationService(EvaluationRepository evaluationRepository) {
        this.evalRepo = evaluationRepository;
    }

    /**
     * Crée une nouvelle évaluation et la persiste en base.
     * 
     * @param evaluation l’objet Evaluation à sauvegarder
     * @return l’entité Evaluation une fois enregistrée (avec son ID généré)
     */
    public Evaluation createEvaluation(Evaluation evaluation) {
        return evalRepo.save(evaluation);
    }

    /**
     * Récupère une évaluation par son ID.
     * 
     * @param id l’ID de l’évaluation
     * @return l’évaluation si trouvée, sinon null
     */
    public Evaluation retrieveEvaluationById(Long id) {
        Optional<Evaluation> opt = evalRepo.findById(id);
        return opt.orElse(null);
    }

    /**
     * Met à jour une évaluation existante.
     * 
     * @param id      l’ID de l’évaluation à mettre à jour
     * @param details l’objet Evaluation contenant les nouvelles valeurs
     * @return l’entité mise à jour, ou null si l’ID n’existe pas
     */
    public Evaluation updateEvaluationById(Long id, Evaluation details) {
        if (evalRepo.existsById(id)) {
            details.setId(id);
            return evalRepo.save(details);
        }
        return null;
    }

    /**
     * Supprime une évaluation donnée par son ID.
     * 
     * @param id l’ID de l’évaluation à supprimer
     */
    public void deleteEvaluationById(Long id) {
        evalRepo.deleteById(id);
    }

    /**
     * Liste toutes les évaluations pour un participant spécifique.
     * 
     * @param participantId l’ID du participant
     * @return liste des évaluations associées
     */
    public List<Evaluation> getEvaluationsForLearner(Long participantId) {
        return evalRepo.findByParticipantId(participantId);
    }

    /**
     * Liste toutes les évaluations pour un topic spécifique.
     * 
     * @param topicId l’ID du topic
     * @return liste des évaluations associées
     */
    public List<Evaluation> getEvaluationsForSubject(Long topicId) {
        return evalRepo.findByTopicId(topicId);
    }
}
