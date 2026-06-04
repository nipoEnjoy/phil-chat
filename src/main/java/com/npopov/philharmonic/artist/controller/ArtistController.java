package com.npopov.philharmonic.artist.controller;

import com.npopov.philharmonic.artist.dto.ArtistMapper;
import com.npopov.philharmonic.shared.controller.GenericRestController;
import com.npopov.philharmonic.artist.dto.ArtistCreateRequest;
import com.npopov.philharmonic.artist.dto.ArtistResponse;
import com.npopov.philharmonic.artist.dto.ArtistUpdateRequest;
import com.npopov.philharmonic.artist.domain.Artist;
import com.npopov.philharmonic.artist.service.ArtistService;
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

    private final GenericRestController<Artist, Long, ArtistResponse, ArtistCreateRequest, ArtistUpdateRequest> genericController;
    private final ArtistService artistService;

    public ArtistController(ArtistService artistService) {
        this.artistService = artistService;
        this.genericController = new GenericRestController<>(
                artistService,
                ArtistMapper::toResponse,
                req -> new Artist(
                        req.firstName(),
                        req.lastName(),
                        req.stageName(),
                        req.contactInfo()
                ),
                (id, req) -> {
                    Artist artist = ArtistMapper.toArtist(req);
                    artist.setId(id);
                    return artist;
                }
        );
    }

    @GetMapping
    public List<ArtistResponse> getAllArtists(
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
            artists = artistService.findAll();
        }
        return artists.stream().map(ArtistMapper::toResponse).collect(Collectors.toList());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ArtistResponse> getById(@PathVariable Long id) {
        return genericController.getById(id);
    }

    @PostMapping
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<ArtistResponse> create(@Valid @RequestBody ArtistCreateRequest request) {
        Artist artist = artistService.create(ArtistMapper.toArtist(request));
        return ResponseEntity.ok(ArtistMapper.toResponse(artist));
    }

    @PutMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN') or hasRole('SUPERADMIN')")
    public ResponseEntity<ArtistResponse> updateArtist(
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