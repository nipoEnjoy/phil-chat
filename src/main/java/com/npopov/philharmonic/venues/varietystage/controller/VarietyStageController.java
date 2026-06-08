package com.npopov.philharmonic.venues.varietystage.controller;

import com.npopov.philharmonic.shared.controller.GenericRestController;
import com.npopov.philharmonic.venues.concert.dto.ConcertVenueCreateRequest;
import com.npopov.philharmonic.venues.concert.dto.ConcertVenueResponse;
import com.npopov.philharmonic.venues.concert.dto.ConcertVenueUpdateRequest;
import com.npopov.philharmonic.venues.varietystage.domain.VarietyStage;
import com.npopov.philharmonic.venues.varietystage.dto.VarietyStageCreateRequest;
import com.npopov.philharmonic.venues.varietystage.dto.VarietyStageMapper;
import com.npopov.philharmonic.venues.varietystage.dto.VarietyStageResponse;
import com.npopov.philharmonic.venues.varietystage.dto.VarietyStageUpdateRequest;
import com.npopov.philharmonic.venues.varietystage.service.VarietyStageService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venues/variety-stage")
public class VarietyStageController {

    private final GenericRestController<VarietyStage, Long,
            VarietyStageResponse, VarietyStageCreateRequest, VarietyStageUpdateRequest> genericController;
    private final VarietyStageService varietyStageService;
    private final VarietyStageMapper varietyStageMapper;

    public VarietyStageController(VarietyStageService varietyStageService, VarietyStageMapper varietyStageMapper) {
        this.varietyStageService = varietyStageService;
        this.varietyStageMapper = varietyStageMapper;
        this.genericController = new GenericRestController<>(
                varietyStageService,
                varietyStageMapper::toResponse,
                varietyStageMapper::toVarietyStageFromCreate,
                (id, req) -> {
                    VarietyStage varietyStage = varietyStageMapper.toVarietyStageFromUpdate(req);
                    varietyStage.setId(id);
                    return varietyStage;
                }
        );
    }

    @GetMapping
    public List<VarietyStageResponse> getAll() {
        return genericController.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VarietyStageResponse> getById(@Valid @PathVariable Long id) {
        return genericController.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<VarietyStageResponse> create(@Valid @RequestBody VarietyStageCreateRequest request) {
        return genericController.create(request);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<VarietyStageResponse> update(
            @Valid @PathVariable Long id,
            @Valid @RequestBody VarietyStageUpdateRequest request) {
        return genericController.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return genericController.delete(id);
    }
}