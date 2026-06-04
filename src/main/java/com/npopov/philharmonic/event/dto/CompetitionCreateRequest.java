package com.npopov.philharmonic.event.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CompetitionCreateRequest(
        @NotNull(message = "Event ID is required")
        Long eventId,

        @Size(max = 100, message = "Competition type must not exceed 100 characters")
        String competitionType,

        @Size(max = 1000, message = "Rules must not exceed 1000 characters")
        String rules,

        @Size(max = 500, message = "Jury info must not exceed 500 characters")
        String juryInfo
) {}