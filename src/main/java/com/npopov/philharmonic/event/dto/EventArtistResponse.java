package com.npopov.philharmonic.event.dto;

import com.npopov.philharmonic.artist.dto.ArtistResponse;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record EventArtistResponse(
        Long id,
        Long eventId,
        Long artistId,
        String role,
        Boolean primaryPerformance,
        BigDecimal fee,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}