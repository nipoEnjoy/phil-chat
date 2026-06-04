package com.npopov.philharmonic.identity.user.dto;

import java.time.LocalDateTime;
import java.util.Set;
import com.npopov.philharmonic.identity.user.domain.Role;

public record UserResponse(
    Long id,
    String username,
    String email,
    Set<Role> roles,
    Boolean enabled,
    LocalDateTime createdAt,
    LocalDateTime updatedAt
) {}
