package com.npopov.philharmonic.genre.dto;

import java.time.LocalDateTime;

public record GenreResponse(
        Long id,
        String name,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}