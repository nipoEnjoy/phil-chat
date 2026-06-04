package com.npopov.philharmonic.identity.auth.dto;

import jakarta.validation.constraints.*;

public record LoginRequest (
    @NotBlank(message = "Username cannot be blank")
    String username,

    @NotBlank(message = "Password cannot be blank")
    String password
){}

