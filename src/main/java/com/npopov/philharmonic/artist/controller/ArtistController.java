package com.npopov.philharmonic.artist.controller;

import com.npopov.philharmonic.artist.dto.ArtistMapper;
import com.npopov.philharmonic.genre.domain.Genre;
import com.npopov.philharmonic.genre.service.GenreService;
import com.npopov.philharmonic.shared.controller.GenericRestController;
import com.npopov.philharmonic.artist.dto.ArtistCreateRequest;
import com.npopov.philharmonic.artist.dto.ArtistResponse;
import com.npopov.philharmonic.artist.dto.ArtistUpdateRequest;
import com.npopov.philharmonic.artist.domain.Artist;
import com.npopov.philharmonic.artist.service.ArtistService;
import com.npopov.philharmonic.shared.exception.ResourceNotFoundException;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/artists")
@Validated
public class ArtistController {

    private final GenericRestController<Artist, Long,
            ArtistResponse, ArtistCreateRequest, ArtistUpdateRequest> genericController;
    private final ArtistService artistService;
    private final ArtistMapper artistMapper;
    private final GenreService genreService;

    public ArtistController(ArtistService artistService, ArtistMapper artistMapper, GenreService genreService) {
        this.artistService = artistService;
        this.artistMapper = artistMapper;
        this.genreService = genreService;
        this.genericController = new GenericRestController<>(
                artistService,
                artistMapper::toResponse,
                artistMapper::toArtistFromCreate,
                (id, req) -> {
                    Artist artist = artistMapper.toArtistFromUpdate(req);
                    artist.setId(id);
                    return artist;
                }
        );
    }

    @GetMapping
    public List<ArtistResponse> getAll(
            @RequestParam(required = false) String genre,
            @RequestParam(required = false) Long impresarioId,
            @RequestParam(required = false) Boolean multipleGenres) {

        List<Artist> artists;
        if (genre != null) {
            artists = artistService.findByGenre(genre);
        } else if (impresarioId != null) {
            artists = artistService.findByImpresario(impresarioId);
        } else if (Boolean.TRUE.equals(multipleGenres)) {
            artists = artistService.findWithMultipleGenres();
        } else {
            artists = artistService.getAll();
        }
        return artists.stream().map(artistMapper::toResponse).collect(Collectors.toList());
    }

    @PostMapping("/{id}/genres/{genreId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<Void> addGenre(@PathVariable Long id, @PathVariable Long genreId) {
        Artist artist = artistService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Artist not found"));
        Genre genre = genreService.findById(genreId)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found"));
        artist.addGenre(genre);
        artistService.update(id, artist);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/genres/{genreId}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<Void> removeGenre(@PathVariable Long id, @PathVariable Long genreId) {
        Artist artist = artistService.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Artist not found"));
        Genre genre = genreService.findById(genreId)
                .orElseThrow(() -> new ResourceNotFoundException("Genre not found"));
        artist.removeGenre(genre);
        artistService.update(id, artist);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistResponse> getById(@PathVariable Long id) {
        return genericController.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<ArtistResponse> create(@Valid @RequestBody ArtistCreateRequest request) {
        return genericController.create(request);
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<ArtistResponse> update(
            @PathVariable Long id,
            @Valid @RequestBody ArtistUpdateRequest request) {
        return genericController.update(id, request);
    }

    @DeleteMapping("/{id}")
    @PreAuthorize("hasRole('SUPERADMIN')")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return genericController.delete(id);
    }
}