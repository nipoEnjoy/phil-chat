package com.npopov.philharmonic.artist.dto;

import com.npopov.philharmonic.artist.domain.Artist;
import com.npopov.philharmonic.genre.domain.Genre;
import com.npopov.philharmonic.genre.dto.GenreResponse;
import com.npopov.philharmonic.genre.repository.GenreRepository;
import com.npopov.philharmonic.identity.user.domain.User;
import com.npopov.philharmonic.identity.user.dto.UserResponse;
import org.springframework.stereotype.Component;

import java.util.Collections;
import java.util.stream.Collectors;

@Component
public class ArtistMapper {

    private final GenreRepository genreRepository;

    private ArtistMapper(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    public Artist toArtistFromCreate(ArtistCreateRequest request) {
        if (request == null) return new Artist();
        return new Artist(
                request.getFirstName(),
                request.getLastName(),
                request.getStageName(),
                request.getContactInfo()
        );
    }

    public Artist toArtistFromUpdate(ArtistUpdateRequest request) {
        if (request == null) return new Artist();
        return new Artist(
                request.getFirstName(),
                request.getLastName(),
                request.getStageName(),
                request.getContactInfo()
        );
    }

    public ArtistResponse toResponse(Artist artist) {
        if (artist == null) return null;
        ArtistResponse response =  new ArtistResponse(
                artist.getId(),
                artist.getFirstName(),
                artist.getLastName(),
                artist.getStageName(),
                artist.getContactInfo(),
                null,
                artist.getCreatedAt(),
                artist.getUpdatedAt()
        );
        if (artist.getGenres() != null && !artist.getGenres().isEmpty()) {
            response.setGenres(artist.getGenres().stream()
                    .map(this::toGenreResponse)
                    .collect(Collectors.toList()));
        } else {
            response.setGenres(Collections.emptyList());
        }
        return response;
    }

    private GenreResponse toGenreResponse(Genre genre) {
        return new GenreResponse(
                genre.getId(),
                genre.getName(),
                genre.getDescription(),
                genre.getCreatedAt(),
                genre.getUpdatedAt()
        );
    }
}
