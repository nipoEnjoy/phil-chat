package com.npopov.philharmonic.event.controller;

import com.npopov.philharmonic.event.domain.CompetitionResult;
import com.npopov.philharmonic.event.service.CompetitionResultService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competition-results")
public class CompetitionResultController {

    private final CompetitionResultService competitionResultService;

    public CompetitionResultController(CompetitionResultService competitionResultService) {
        this.competitionResultService = competitionResultService;
    }

    @GetMapping
    public List<CompetitionResult> getAllCompetitionResults(@RequestParam(required = false) Long competitionId) {
        if (competitionId != null) {
            return competitionResultService.findByCompetition(competitionId);
        }
        return competitionResultService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetitionResult> getCompetitionResultById(@PathVariable Long id) {
        return competitionResultService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public CompetitionResult createCompetitionResult(@RequestBody CompetitionResult competitionResult) {
        return competitionResultService.save(competitionResult);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompetitionResult> updateCompetitionResult(@PathVariable Long id, @RequestBody CompetitionResult competitionResult) {
        if (!competitionResultService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        competitionResult.setId(id);
        return ResponseEntity.ok(competitionResultService.save(competitionResult));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetitionResult(@PathVariable Long id) {
        if (!competitionResultService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        competitionResultService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}