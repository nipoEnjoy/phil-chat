package com.npopov.philharmonic.event.service;

import com.npopov.philharmonic.event.domain.Competition;
import com.npopov.philharmonic.event.repository.CompetitionRepository;
import com.npopov.philharmonic.shared.service.JpaCrudService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompetitionService extends JpaCrudService<Competition, Long> {

    private final CompetitionRepository repository;

    public CompetitionService(CompetitionRepository repository) {
        super(repository);
        this.repository = repository;
    }
}