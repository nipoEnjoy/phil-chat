package com.npopov.philharmonic.events.competition.repository;

import com.npopov.philharmonic.events.competition.domain.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}