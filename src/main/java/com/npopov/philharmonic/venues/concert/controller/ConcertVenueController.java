package com.npopov.philharmonic.venues.concert.controller;

import com.npopov.philharmonic.shared.controller.GenericRestController;
import com.npopov.philharmonic.venues.concert.domain.ConcertVenue;
import com.npopov.philharmonic.venues.concert.dto.ConcertVenueCreateRequest;
import com.npopov.philharmonic.venues.concert.dto.ConcertVenueMapper;
import com.npopov.philharmonic.venues.concert.dto.ConcertVenueResponse;
import com.npopov.philharmonic.venues.concert.dto.ConcertVenueUpdateRequest;
import com.npopov.philharmonic.venues.concert.service.ConcertVenueService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venues/concert")
public class ConcertVenueController {

    private final GenericRestController<ConcertVenue, Long, ConcertVenueResponse, ConcertVenueCreateRequest, ConcertVenueUpdateRequest> genericController;
    private final ConcertVenueService concertVenueService;
    private ConcertVenueMapper concertVenueMapper;

    public ConcertVenueController(ConcertVenueService concertVenueService, ConcertVenueMapper concertVenueMapper) {
        this.concertVenueService = concertVenueService;
        this.genericController = new GenericRestController<>(
                concertVenueService,
                concertVenueMapper::toResponse,
                concertVenueMapper::toConcertVenueFromCreate,
                (id, req) -> {
                    ConcertVenue concertVenue = concertVenueMapper.toConcertVenueFromUpdate(req);
                    concertVenue.setId(id);
                    return concertVenue;
                }
        );
    }

    @GetMapping
    public List<ConcertVenueResponse> getAll() {
        return genericController.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ConcertVenueResponse> getById(@Valid @PathVariable Long id) {
        return genericController.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<ConcertVenueResponse> create(@Valid @RequestBody ConcertVenueCreateRequest request) {
        return genericController.create(request);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<ConcertVenueResponse> update(
            @Valid @PathVariable Long id,
            @Valid @RequestBody ConcertVenueUpdateRequest request) {
        return genericController.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return genericController.delete(id);
    }
}