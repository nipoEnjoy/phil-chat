package com.npopov.philharmonic.events.concert.controller;

import com.npopov.philharmonic.events.concert.domain.Concert;
import com.npopov.philharmonic.events.concert.dto.ConcertCreateRequest;
import com.npopov.philharmonic.events.concert.dto.ConcertMapper;
import com.npopov.philharmonic.events.concert.dto.ConcertResponse;
import com.npopov.philharmonic.events.concert.dto.ConcertUpdateRequest;
import com.npopov.philharmonic.events.concert.service.ConcertService;
import com.npopov.philharmonic.shared.controller.GenericRestController;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/events/concert")
public class ConcertController {

    private final GenericRestController<Concert, Long,
            ConcertResponse, ConcertCreateRequest, ConcertUpdateRequest> genericController;
    private final ConcertService concertService;
    private final ConcertMapper concertMapper;

    public ConcertController(ConcertService concertService, ConcertMapper concertMapper) {
        this.concertService = concertService;
        this.concertMapper = concertMapper;
        this.genericController = new GenericRestController<>(
                concertService,
                concertMapper::toResponse,
                concertMapper::toConcertFromCreate,
                (id, req) -> {
                    Concert concert = concertMapper.toConcertFromUpdate(req);
                    concert.setId(id);
                    return concert;
                }
        );
    }

    @GetMapping
    public List<ConcertResponse> getAll() {
        return genericController.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConcertResponse> getById(@PathVariable Long id) {
        return genericController.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<ConcertResponse> create(@RequestBody ConcertCreateRequest request) {
        return genericController.create(request);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<ConcertResponse> update(
            @PathVariable Long id,
            @RequestBody ConcertUpdateRequest request) {
        return genericController.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return genericController.delete(id);
    }
}