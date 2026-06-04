package com.npopov.philharmonic.event.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record CompetitionResultCreateRequest(
        @NotNull(message = "Competition ID is required")
        Long competitionId,

        @NotNull(message = "Artist ID is required")
        Long artistId,

        Integer place,

        @Size(max = 200, message = "Award must not exceed 200 characters")
        String award
) {}