package com.npopov.philharmonic.venues.cinema.controller;

import com.npopov.philharmonic.shared.controller.GenericRestController;
import com.npopov.philharmonic.venues.cinema.domain.Cinema;
import com.npopov.philharmonic.venues.cinema.dto.CinemaCreateRequest;
import com.npopov.philharmonic.venues.cinema.dto.CinemaMapper;
import com.npopov.philharmonic.venues.cinema.dto.CinemaResponse;
import com.npopov.philharmonic.venues.cinema.dto.CinemaUpdateRequest;
import com.npopov.philharmonic.venues.cinema.service.CinemaService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/venues/cinema")
@Validated
public class CinemaController {

    private final GenericRestController<Cinema, Long, CinemaResponse, CinemaCreateRequest, CinemaUpdateRequest> genericController;
    private final CinemaService cinemaSerivce;
    private final CinemaMapper cinemaMapper;

    public CinemaController(CinemaService cinemaService, CinemaMapper cinemaMapper) {
        this.cinemaSerivce = cinemaService;
        this.cinemaMapper = cinemaMapper;
        this.genericController = new GenericRestController<>(
                cinemaService,
                cinemaMapper::toResponse,
                cinemaMapper::toCinemaFromCreate,
                (id, req) -> {
                    Cinema cinema = cinemaMapper.toCinemaFromUpdate(req);
                    cinema.setId(id);
                    return cinema;
                }
        );
    }
    
    @GetMapping
    public List<CinemaResponse> getAll() {
        return genericController.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CinemaResponse> getById(@Valid @PathVariable Long id) {
        return genericController.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<CinemaResponse> create(@Valid @RequestBody CinemaCreateRequest request) {
        return genericController.create(request);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<CinemaResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody CinemaUpdateRequest request) {
        return genericController.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN')")
    public ResponseEntity<Void> delete(@Valid @PathVariable Long id) {
        return genericController.delete(id);
    }
}
