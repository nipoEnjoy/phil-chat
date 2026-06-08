package com.npopov.philharmonic.events.competition.controller;

import com.npopov.philharmonic.events.competition.domain.Competition;
import com.npopov.philharmonic.events.competition.dto.CompetitionCreateRequest;
import com.npopov.philharmonic.events.competition.dto.CompetitionMapper;
import com.npopov.philharmonic.events.competition.dto.CompetitionResponse;
import com.npopov.philharmonic.events.competition.dto.CompetitionUpdateRequest;
import com.npopov.philharmonic.events.competition.service.CompetitionService;
import com.npopov.philharmonic.shared.controller.GenericRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competitions")
public class CompetitionController {

    private final GenericRestController<Competition, Long,
            CompetitionResponse, CompetitionCreateRequest, CompetitionUpdateRequest> genericController;
    private final CompetitionService competitionService;
    private final CompetitionMapper competitionMapper;

    public CompetitionController(CompetitionService competitionService, CompetitionMapper competitionMapper) {
        this.competitionService = competitionService;
        this.competitionMapper = competitionMapper;
        this.genericController = new GenericRestController<>(
                competitionService,
                competitionMapper::toResponse,
                competitionMapper::toCompetitionFromCreate,
                (id, req) -> {
                    Competition competition = competitionMapper.toCompetitionFromUpdate(req);
                    competition.setId(id);
                    return competition;
                }
        );
    }

    @GetMapping
    public List<CompetitionResponse> getAllCompetitions() {
        return genericController.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetitionResponse> getCompetitionById(@PathVariable Long id) {
        return genericController.getById(id);
    }

    @PostMapping
    public ResponseEntity<CompetitionResponse> createCompetition(@RequestBody CompetitionCreateRequest request) {
        return genericController.create(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompetitionResponse> updateCompetition(
            @PathVariable Long id,
            @RequestBody CompetitionUpdateRequest request) {
        return genericController.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetition(@PathVariable Long id) {
        return genericController.delete(id);
    }
}