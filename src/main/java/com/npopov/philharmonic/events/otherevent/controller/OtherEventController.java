package com.npopov.philharmonic.events.otherevent.controller;

import com.npopov.philharmonic.events.otherevent.domain.OtherEvent;
import com.npopov.philharmonic.events.otherevent.dto.OtherEventCreateRequest;
import com.npopov.philharmonic.events.otherevent.dto.OtherEventMapper;
import com.npopov.philharmonic.events.otherevent.dto.OtherEventResponse;
import com.npopov.philharmonic.events.otherevent.dto.OtherEventUpdateRequest;
import com.npopov.philharmonic.events.otherevent.service.OtherEventService;
import com.npopov.philharmonic.shared.controller.GenericRestController;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events/other")
public class OtherEventController {

    private final GenericRestController<OtherEvent, Long, OtherEventResponse,
            OtherEventCreateRequest, OtherEventUpdateRequest> genericController;

    public OtherEventController(OtherEventService otherEventService,
                                OtherEventMapper otherEventMapper) {
        this.genericController = new GenericRestController<>(
                otherEventService,
                otherEventMapper::toResponse,
                otherEventMapper::toOtherEventFromCreate,
                (id, req) -> {
                    OtherEvent entity = otherEventMapper.toOtherEventFromUpdate(req);
                    entity.setId(id);
                    return entity;
                }
        );
    }

    @GetMapping
    public List<OtherEventResponse> getAll() {
        return genericController.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OtherEventResponse> getById(@PathVariable Long id) {
        return genericController.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<OtherEventResponse> create(@Valid @RequestBody OtherEventCreateRequest request) {
        return genericController.create(request);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<OtherEventResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody OtherEventUpdateRequest request) {
        return genericController.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return genericController.delete(id);
    }
}
