package com.npopov.philharmonic.event.service;

import com.npopov.philharmonic.event.domain.CompetitionResult;
import com.npopov.philharmonic.event.repository.CompetitionResultRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetitionResultService {

    private final CompetitionResultRepository competitionResultRepository;

    public CompetitionResultService(CompetitionResultRepository competitionResultRepository) {
        this.competitionResultRepository = competitionResultRepository;
    }

    public List<CompetitionResult> findAll() {
        return competitionResultRepository.findAll();
    }

    public List<CompetitionResult> findByCompetition(Long competitionId) {
        return competitionResultRepository.findByCompetition_Id(competitionId);
    }

    public Optional<CompetitionResult> findById(Long id) {
        return competitionResultRepository.findById(id);
    }

    public CompetitionResult save(CompetitionResult competitionResult) {
        return competitionResultRepository.save(competitionResult);
    }

    public void deleteById(Long id) {
        competitionResultRepository.deleteById(id);
    }
}