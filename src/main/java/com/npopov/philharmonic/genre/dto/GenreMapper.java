package com.npopov.philharmonic.genre.dto;

import com.npopov.philharmonic.genre.domain.Genre;

public class GenreMapper {
    private GenreMapper() {}

    public static Genre toGenre(GenreCreateRequest request) {
        return new Genre(
                request.name(),
                request.description()
        );
    }

    public static Genre toGenre(GenreUpdateRequest request) {
        return new Genre(
                request.name(),
                request.description()
        );
    }

    public static GenreResponse toResponse(Genre genre) {
        return new GenreResponse(
                genre.getId(),
                genre.getName(),
                genre.getDescription(),
                genre.getCreatedAt(),
                genre.getUpdatedAt()
        );
    }
}
