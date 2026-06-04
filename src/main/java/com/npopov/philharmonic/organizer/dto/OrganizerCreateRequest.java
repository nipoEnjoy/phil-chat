package com.npopov.philharmonic.organizer.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record OrganizerCreateRequest(
        @NotBlank(message = "Name cannot be blank")
        @Size(max = 100, message = "Name must not exceed 100 characters")
        String name,

        @Size(max = 200, message = "Contact info must not exceed 200 characters")
        String contactInfo,

        @Size(max = 50, message = "Type must not exceed 50 characters")
        String type
) {}