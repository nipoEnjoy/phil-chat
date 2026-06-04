package com.npopov.philharmonic.event.repository;

import com.npopov.philharmonic.event.domain.Competition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompetitionRepository extends JpaRepository<Competition, Long> {
}