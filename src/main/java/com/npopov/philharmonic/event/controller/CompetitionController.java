package com.npopov.philharmonic.event.controller;

import com.npopov.philharmonic.event.domain.Competition;
import com.npopov.philharmonic.event.service.CompetitionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competitions")
public class CompetitionController {

    private final CompetitionService competitionService;

    public CompetitionController(CompetitionService competitionService) {
        this.competitionService = competitionService;
    }

    @GetMapping
    public List<Competition> getAllCompetitions() {
        return competitionService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Competition> getCompetitionById(@PathVariable Long id) {
        return competitionService.findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Competition createCompetition(@RequestBody Competition competition) {
        return competitionService.save(competition);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Competition> updateCompetition(@PathVariable Long id, @RequestBody Competition competition) {
        if (!competitionService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        competition.setId(id);
        return ResponseEntity.ok(competitionService.save(competition));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetition(@PathVariable Long id) {
        if (!competitionService.findById(id).isPresent()) {
            return ResponseEntity.notFound().build();
        }
        competitionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}