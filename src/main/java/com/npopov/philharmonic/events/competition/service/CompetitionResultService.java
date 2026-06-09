package com.npopov.philharmonic.events.competition.service;

import com.npopov.philharmonic.events.competition.domain.CompetitionResult;
import com.npopov.philharmonic.events.competition.repository.CompetitionResultRepository;
import com.npopov.philharmonic.shared.service.JpaCrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetitionResultService extends JpaCrudService<CompetitionResult, Long> {

    private final CompetitionResultRepository competitionResultRepository;

    public CompetitionResultService(CompetitionResultRepository competitionResultRepository) {
        super(competitionResultRepository);
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