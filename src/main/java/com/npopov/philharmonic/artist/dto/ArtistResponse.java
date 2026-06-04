package com.npopov.philharmonic.artist.dto;

import java.time.LocalDateTime;

public record ArtistResponse(
        Long id,
        String firstName,
        String lastName,
        String stageName,
        String contactInfo,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}