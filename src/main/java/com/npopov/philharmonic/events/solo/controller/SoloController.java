package com.npopov.philharmonic.events.solo.controller;

import com.npopov.philharmonic.events.solo.domain.Solo;
import com.npopov.philharmonic.events.solo.dto.SoloCreateRequest;
import com.npopov.philharmonic.events.solo.dto.SoloMapper;
import com.npopov.philharmonic.events.solo.dto.SoloResponse;
import com.npopov.philharmonic.events.solo.dto.SoloUpdateRequest;
import com.npopov.philharmonic.events.solo.service.SoloService;
import com.npopov.philharmonic.shared.controller.GenericRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events/solo")
public class SoloController {

    private final GenericRestController<Solo, Long,
            SoloResponse, SoloCreateRequest, SoloUpdateRequest> genericController;
    private final SoloService soloService;
    private final SoloMapper soloMapper;

    public SoloController(SoloService soloService, SoloMapper soloMapper) {
        this.soloService = soloService;
        this.soloMapper = soloMapper;
        this.genericController = new GenericRestController<>(
                soloService,
                soloMapper::toResponse,
                soloMapper::toSoloFromCreate,
                (id, req) -> {
                    Solo solo = soloMapper.toSoloFromUpdate(req);
                    solo.setId(id);
                    return solo;
                }
        );
    }


    @GetMapping
    public List<SoloResponse> getAll() {
        return genericController.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SoloResponse> getById(@PathVariable Long id) {
        return genericController.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<SoloResponse> create(@RequestBody SoloCreateRequest request) {
        return genericController.create(request);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<SoloResponse> update(
            @PathVariable Long id,
            @RequestBody SoloUpdateRequest request) {
        return genericController.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return genericController.delete(id);
    }
}
