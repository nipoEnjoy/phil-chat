package com.npopov.philharmonic.organizer.controller;

import com.npopov.philharmonic.organizer.domain.Organizer;
import com.npopov.philharmonic.organizer.dto.OrganizerCreateRequest;
import com.npopov.philharmonic.organizer.dto.OrganizerMapper;
import com.npopov.philharmonic.organizer.dto.OrganizerResponse;
import com.npopov.philharmonic.organizer.dto.OrganizerUpdateRequest;
import com.npopov.philharmonic.organizer.service.OrganizerService;
import com.npopov.philharmonic.shared.controller.GenericRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizers")
public class OrganizerController {

    private final GenericRestController<Organizer, Long,
            OrganizerResponse, OrganizerCreateRequest, OrganizerUpdateRequest> genericController;
    private final OrganizerService organizerService;
    private final OrganizerMapper organizerMapper;

    public OrganizerController(OrganizerService organizerService, OrganizerMapper organizerMapper) {
        this.organizerService = organizerService;
        this.organizerMapper = organizerMapper;
        this.genericController = new GenericRestController<>(
                organizerService,
                organizerMapper::toResponse,
                organizerMapper::toOrganizerFromCreate,
                (id, req) -> {
                    Organizer organizer = organizerMapper.toOrganizerFromUpdate(req);
                    organizer.setId(id);
                    return organizer;
                }
        );
    }

    @GetMapping
    public List<OrganizerResponse> getAll() {
        return genericController.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizerResponse> getById(@PathVariable Long id) {
        return genericController.getById(id);
    }

    @PostMapping
    public ResponseEntity<OrganizerResponse> create(@RequestBody OrganizerCreateRequest request) {
        return genericController.create(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizerResponse> update(@PathVariable Long id, @RequestBody OrganizerUpdateRequest organizer) {
        return genericController.update(id, organizer);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return  genericController.delete(id);
    }
}