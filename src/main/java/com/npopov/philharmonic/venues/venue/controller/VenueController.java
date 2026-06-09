package com.npopov.philharmonic.venues.venue.controller;

import com.npopov.philharmonic.shared.controller.GenericRestController;
import com.npopov.philharmonic.venues.venue.dto.VenueCreateRequest;
import com.npopov.philharmonic.venues.venue.dto.VenueMapper;
import com.npopov.philharmonic.venues.venue.dto.VenueResponse;
import com.npopov.philharmonic.venues.venue.domain.Venue;
import com.npopov.philharmonic.venues.venue.domain.VenueType;
import com.npopov.philharmonic.venues.venue.dto.VenueUpdateRequest;
import com.npopov.philharmonic.venues.venue.service.VenueService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/venues")
public class VenueController {

    private final GenericRestController<Venue, Long,
            VenueResponse, VenueCreateRequest, VenueUpdateRequest> genericController;
    private final VenueService venueService;
    private final VenueMapper venueMapper;

    public VenueController(VenueService venueService, VenueMapper venueMapper) {
        this.venueService = venueService;
        this.venueMapper = venueMapper;
        this.genericController = new GenericRestController<>(
                venueService,
                venueMapper::toResponse,
                venueMapper::toVenueFromCreate,
                (id, req) -> {
                    Venue venue = venueMapper.toVenueFromUpdate(req);
                    venue.setId(id);
                    return venue;
                }
        );
    }

    @GetMapping
    public ResponseEntity<List<VenueResponse>> getAll(@RequestParam(required = false) VenueType type) {
        List<Venue> venues;
        if (type != null) {
            venues = venueService.findByVenueType(type);
        } else {
            venues = venueService.getAll();
        }
        return ResponseEntity.ok(venues.stream()
                .map(venueService::toResponse)
                .collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity<VenueResponse> getById(@PathVariable Long id) {
        return genericController.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<VenueResponse> create(@Valid @RequestBody VenueCreateRequest request) {
        Venue venue = venueService.createFromRequest(request);
        return ResponseEntity.ok(venueService.toResponse(venue));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<VenueResponse> update(@PathVariable Long id,
                                                @Valid @RequestBody VenueUpdateRequest request) {
        return genericController.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return genericController.delete(id);
    }
}