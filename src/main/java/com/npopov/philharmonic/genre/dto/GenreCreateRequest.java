package com.npopov.philharmonic.genre.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record GenreCreateRequest(
        @NotBlank(message = "Genre name cannot be blank")
        @Size(max = 100, message = "Genre name must not exceed 100 characters")
        String name,

        @Size(max = 500, message = "Description must not exceed 500 characters")
        String description
) {}