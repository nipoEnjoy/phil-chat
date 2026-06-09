package com.npopov.philharmonic.artist.service;

import com.npopov.philharmonic.artist.dto.ArtistCreateRequest;
import com.npopov.philharmonic.artist.dto.ArtistResponse;
import com.npopov.philharmonic.artist.domain.Artist;
import com.npopov.philharmonic.artist.repository.ArtistRepository;
import com.npopov.philharmonic.shared.service.JpaCrudService;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ArtistService extends JpaCrudService<Artist, Long> {

    private final ArtistRepository repository;

    public ArtistService(ArtistRepository repository) {
        super(repository);
        this.repository = repository;
    }

    @Override
    @Transactional
    public Optional<Artist> findById(Long id) {
        return repository.findByIdWithGenres(id);
    }

    @Transactional
    public List<Artist> findAll() {
        return repository.findAllWithGenres();
    }

    public List<Artist> findByGenre(String genreName) {
        return repository.findByArtistGenres_Genre_Name(genreName);
    }

    public List<Artist> findByImpresario(Long impresarioId) {
        return repository.findByArtistImpresarios_Impresario_Id(impresarioId);
    }

    public List<Artist> findWithMultipleGenres() {
        return repository.findArtistsWithMultipleGenres();
    }
}