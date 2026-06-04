package com.npopov.philharmonic.event.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public record EventArtistCreateRequest(
        @NotNull(message = "Event ID is required")
        Long eventId,

        @NotNull(message = "Artist ID is required")
        Long artistId,

        @Size(max = 100, message = "Role must not exceed 100 characters")
        String role,

        Boolean primaryPerformance,

        BigDecimal fee
) {}