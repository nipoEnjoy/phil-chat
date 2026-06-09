package com.npopov.philharmonic.events.competition.controller;

import com.npopov.philharmonic.events.competition.domain.CompetitionResult;
import com.npopov.philharmonic.events.competition.dto.CompetitionResultCreateRequest;
import com.npopov.philharmonic.events.competition.dto.CompetitionResultMapper;
import com.npopov.philharmonic.events.competition.dto.CompetitionResultResponse;
import com.npopov.philharmonic.events.competition.dto.CompetitionResultUpdateRequest;
import com.npopov.philharmonic.events.competition.service.CompetitionResultService;
import com.npopov.philharmonic.shared.controller.GenericRestController;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events/competition/results")
public class CompetitionResultController {

    private final GenericRestController<CompetitionResult, Long,
            CompetitionResultResponse, CompetitionResultCreateRequest, CompetitionResultUpdateRequest> genericController;
    private final CompetitionResultService competitionResultService;
    private final CompetitionResultMapper competitionResultMapper;

    public CompetitionResultController(CompetitionResultService competitionResultService, CompetitionResultMapper competitionResultMapper) {
        this.competitionResultService = competitionResultService;
        this.competitionResultMapper = competitionResultMapper;
        this.genericController = new GenericRestController<>(
                competitionResultService,
                competitionResultMapper::toResponse,
                competitionResultMapper::toCompetitionResultFromCreate,
                (id, req) -> {
                    CompetitionResult competitionResult = competitionResultMapper.toCompetitionResultFromUpdate(req);
                    competitionResult.setId(id);
                    return competitionResult;
                }
        );
    }

    @GetMapping
    public ResponseEntity<List<CompetitionResultResponse>> getAll(@RequestParam(required = false) Long competitionId) {
        return ResponseEntity.ok(genericController.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CompetitionResultResponse> getById(@PathVariable Long id) {
        return genericController.getById(id);
    }

    @PostMapping
    public ResponseEntity<CompetitionResultResponse> createCompetitionResult(@Valid @RequestBody CompetitionResultCreateRequest request) {
        return genericController.create(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<CompetitionResultResponse> updateCompetitionResult(
            @PathVariable Long id,
            @Valid @RequestBody CompetitionResultUpdateRequest request) {
        return genericController.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCompetitionResult(@PathVariable Long id) {
        return genericController.delete(id);
    }
}