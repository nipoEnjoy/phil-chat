package com.npopov.philharmonic.identity.user.dto;

import com.npopov.philharmonic.identity.auth.dto.RegisterRequest;
import com.npopov.philharmonic.identity.user.domain.User;

public final class UserMapper {
    private UserMapper() {}

    public static User toUser(RegisterRequest request) {
        if (request == null) return new User();
        return new User(
                request.username(),
                request.password(),
                request.email(),
                request.roles()
        );
    }

    public static UserResponse toResponse(User user) {
        if (user == null) return null;
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getRoles(),
                user.getEnabled(),
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}