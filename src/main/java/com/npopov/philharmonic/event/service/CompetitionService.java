package com.npopov.philharmonic.event.service;

import com.npopov.philharmonic.event.domain.Competition;
import com.npopov.philharmonic.event.repository.CompetitionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetitionService {

    private final CompetitionRepository competitionRepository;

    public CompetitionService(CompetitionRepository competitionRepository) {
        this.competitionRepository = competitionRepository;
    }

    public List<Competition> findAll() {
        return competitionRepository.findAll();
    }

    public Optional<Competition> findById(Long id) {
        return competitionRepository.findById(id);
    }

    public Competition save(Competition competition) {
        return competitionRepository.save(competition);
    }

    public void deleteById(Long id) {
        competitionRepository.deleteById(id);
    }
}