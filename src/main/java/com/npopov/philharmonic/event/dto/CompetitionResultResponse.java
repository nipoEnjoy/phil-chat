package com.npopov.philharmonic.event.dto;

import com.npopov.philharmonic.artist.dto.ArtistResponse;

import java.time.LocalDateTime;

public record CompetitionResultResponse(
        Long id,
        Long competitionId,
        Long artistId,
        Integer place,
        String award,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}