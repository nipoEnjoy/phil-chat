package com.npopov.philharmonic.genre.controller;

import com.npopov.philharmonic.genre.domain.Genre;
import com.npopov.philharmonic.genre.dto.GenreCreateRequest;
import com.npopov.philharmonic.genre.dto.GenreMapper;
import com.npopov.philharmonic.genre.dto.GenreResponse;
import com.npopov.philharmonic.genre.dto.GenreUpdateRequest;
import com.npopov.philharmonic.genre.service.GenreService;
import com.npopov.philharmonic.shared.controller.GenericRestController;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/genres")
public class GenreController {

    private final GenericRestController<Genre, Long, GenreResponse, GenreCreateRequest, GenreUpdateRequest> genericController;
    private final GenreService genreService;

    public GenreController(GenreService genreService) {
        this.genreService = genreService;
        this.genericController = new GenericRestController<>(
                genreService,
                GenreMapper::toResponse,
                GenreMapper::toGenre,
                (id, updateRequest) -> {
                    Genre genre = GenreMapper.toGenre(updateRequest);
                    genre.setId(id);
                    return genre;
                }
        );
    }

    @GetMapping
    public List<GenreResponse> getAllGenres() {
        return genericController.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenreResponse> getGenreById(@PathVariable Long id) {
        return genericController.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<GenreResponse> createGenre(@Valid @RequestBody GenreCreateRequest request) {
        return genericController.create(request);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<GenreResponse> updateGenre(
            @PathVariable Long id,
            @Valid @RequestBody GenreUpdateRequest request) {

        return genreService.findById(id).map(existing -> {
            Genre toSave = new Genre(request.name(), request.description());
            toSave.setId(id);
            Genre saved = genreService.create(toSave);
            return ResponseEntity.ok(new GenreResponse(
                    saved.getId(),
                    saved.getName(),
                    saved.getDescription(),
                    saved.getCreatedAt(),
                    saved.getUpdatedAt()
            ));
        }).orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN')")
    public ResponseEntity<Void> deleteGenre(@PathVariable Long id) {
        return genericController.delete(id);
    }
}