package com.npopov.philharmonic.venue.dto;

import com.npopov.philharmonic.venue.domain.VenueType;
import java.time.LocalDateTime;

public record VenueResponse(
        Long id,
        String name,
        VenueType venueType,
        String address,
        String city,
        String description,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {}