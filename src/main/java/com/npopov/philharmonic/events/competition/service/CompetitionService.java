package com.npopov.philharmonic.events.competition.service;

import com.npopov.philharmonic.events.competition.domain.Competition;
import com.npopov.philharmonic.events.competition.repository.CompetitionRepository;
import com.npopov.philharmonic.shared.service.JpaCrudService;
import org.springframework.stereotype.Service;

@Service
public class CompetitionService extends JpaCrudService<Competition, Long> {

    private final CompetitionRepository repository;

    public CompetitionService(CompetitionRepository repository) {
        super(repository);
        this.repository = repository;
    }
}