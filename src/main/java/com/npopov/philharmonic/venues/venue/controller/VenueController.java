package com.npopov.philharmonic.venues.venue.controller;

import com.npopov.philharmonic.venues.venue.dto.VenueCreateRequest;
import com.npopov.philharmonic.venues.venue.dto.VenueMapper;
import com.npopov.philharmonic.venues.venue.dto.VenueResponse;
import com.npopov.philharmonic.venues.venue.domain.Venue;
import com.npopov.philharmonic.venues.venue.domain.VenueType;
import com.npopov.philharmonic.venues.venue.dto.VenueUpdateRequest;
import com.npopov.philharmonic.venues.venue.service.VenueService;
import com.npopov.philharmonic.shared.controller.GenericRestController;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/venues")
public class VenueController {

    private final GenericRestController<Venue, Long, VenueResponse, VenueCreateRequest, VenueUpdateRequest> genericCoontoller;
    private final VenueService venueService;

    public VenueController(VenueService venueService) {
        this.venueService = venueService;
        this.genericCoontoller = new GenericRestController<>(
                venueService,
                VenueMapper::toResponse,
                VenueMapper::toVenue,
                (id, request) -> {
                    Venue venue = VenueMapper.toVenue(request);
                    venue.setId(id);
                    return venue;
                }
        );
    }

    @GetMapping
    public List<VenueResponse> getAll(@RequestParam(required = false) VenueType type) {
        List<Venue> list = type == null ? venueService.getAll() : venueService.findByVenueType(type);
        return list.stream().map(VenueMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<VenueResponse> getById(@PathVariable Long id) {
        return genericCoontoller.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<VenueResponse> create(@Valid @RequestBody VenueCreateRequest request) {
        return genericCoontoller.create(request);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<VenueResponse> update(@PathVariable Long id, @Valid @RequestBody VenueUpdateRequest request) {
        return genericCoontoller.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return genericCoontoller.delete(id);
    }
}