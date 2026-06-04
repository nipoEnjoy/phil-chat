package com.npopov.philharmonic.venue.dto;

import com.npopov.philharmonic.venue.domain.VenueType;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record VenueCreateRequest(
        @NotBlank(message = "Venue name cannot be blank")
        @Size(max = 100, message = "Venue name must not exceed 100 characters")
        String name,

        @NotNull(message = "Venue type is required")
        VenueType venueType,

        @Size(max = 200, message = "Address must not exceed 200 characters")
        String address,

        @Size(max = 100, message = "City must not exceed 100 characters")
        String city,

        @Size(max = 500, message = "Description must not exceed 500 characters")
        String description
) {}