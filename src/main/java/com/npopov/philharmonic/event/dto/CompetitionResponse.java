package com.npopov.philharmonic.event.dto;

import java.time.LocalDateTime;

public record CompetitionResponse(
        Long id,
        Long eventId,
        String competitionType,
        String rules,
        String juryInfo,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}