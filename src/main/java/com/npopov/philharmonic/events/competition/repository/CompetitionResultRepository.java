package com.npopov.philharmonic.events.competition.repository;

import com.npopov.philharmonic.events.competition.domain.CompetitionResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetitionResultRepository extends JpaRepository<CompetitionResult, Long> {
    List<CompetitionResult> findByCompetition_Id(Long competitionId);
}