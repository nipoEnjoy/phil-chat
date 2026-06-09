package com.npopov.philharmonic.identity.role.dto;

import com.npopov.philharmonic.identity.role.domain.Role;
import org.springframework.stereotype.Component;

@Component
public class RoleMapper {

    public Role toRoleFromCreate(RoleCreateRequest request) {
        if (request == null) return new Role();
        return new Role(
                request.getName(),
                request.getDescription(),
                request.getPermissions()
        );
    }

    public Role toRoleFromUpdate(RoleUpdateRequest request) {
        if (request == null) return new Role();
        return new Role(
                request.getName(),
                request.getDescription(),
                request.getPermissions()
        );
    }

    public RoleResponse toResponse(Role role) {
        if (role == null) return null;
        return new RoleResponse(
                role.getId(),
                role.getName(),
                role.getDescription(),
                role.getPermissions(),
                role.getCreatedAt(),
                role.getUpdatedAt()
        );
    }
}