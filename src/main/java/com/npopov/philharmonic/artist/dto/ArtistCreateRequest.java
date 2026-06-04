package com.npopov.philharmonic.artist.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record ArtistCreateRequest(
        @NotBlank(message = "First name cannot be blank")
        @Size(max = 100, message = "First name must not exceed 100 characters")
        String firstName,

        @Size(max = 100, message = "Last name must not exceed 100 characters")
        String lastName,

        @Size(max = 100, message = "Stage name must not exceed 100 characters")
        String stageName,

        @Size(max = 200, message = "Contact info must not exceed 200 characters")
        String contactInfo
) {}