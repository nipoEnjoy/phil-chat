package com.npopov.philharmonic.identity.auth.dto;

import com.npopov.philharmonic.identity.role.domain.Role;
import jakarta.validation.constraints.*;
import java.util.Set;

public record RegisterRequest (
    @NotBlank(message = "Username cannot be blank")
    @Size(max = 50, message = "Username must not exceed 50 characters")
    String username,

    @NotBlank(message = "Password cannot be blank")
    @Size(min = 6, max = 255, message = "Password must be between 6 and 255 characters")
    String password,

    @Email(message = "Email must be valid")
    @Size(max = 100, message = "Email must not exceed 100 characters")
    String email,

    @NotNull(message = "Roles cannot be null")
    Set<String> roles
){}
