package com.npopov.philharmonic.event.repository;

import com.npopov.philharmonic.event.domain.CompetitionResult;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CompetitionResultRepository extends JpaRepository<CompetitionResult, Long> {
    List<CompetitionResult> findByCompetition_Id(Long competitionId);
}