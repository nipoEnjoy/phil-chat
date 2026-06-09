package com.npopov.philharmonic.identity.user.dto;

import com.npopov.philharmonic.identity.auth.dto.RegisterRequest;
import com.npopov.philharmonic.identity.role.domain.Role;
import com.npopov.philharmonic.identity.role.dto.RoleMapper;
import com.npopov.philharmonic.identity.role.dto.RoleResponse;
import com.npopov.philharmonic.identity.role.repository.RoleRepository;
import com.npopov.philharmonic.identity.user.domain.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class UserMapper {

    private final RoleRepository roleRepository;
    private RoleMapper roleMapper;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserMapper(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public User toUserFromRegister(RegisterRequest request) {
        Set<Role> roleEntities = request.roles().stream()
                .map(roleName -> roleRepository.findByName(roleName)
                        .orElseThrow(() -> new IllegalArgumentException("Role not found: " + roleName)))
                .collect(Collectors.toSet());
        User user = new User();
        user.setUsername(request.username());
        user.setPassword(passwordEncoder.encode(request.password()));
        user.setEmail(request.email());
        user.setRoles(roleEntities);
        return user;
    }

    public User toUserFromCreate(UserCreateRequest request) {
        if (request == null) return new User();
        User user = new User();
        user.setUsername(request.getUsername());
        user.setPassword(request.getPassword());
        user.setEmail(request.getEmail());
        user.setEnabled(request.getEnabled() != null ? request.getEnabled() : true);
        return user;
    }

    public User toUserFromUpdate(UserUpdateRequest request) {
        if (request == null) return new User();
        User user = new User();
        user.setUsername(request.getUsername());
        user.setEmail(request.getEmail());
        user.setEnabled(request.getEnabled());
        return user;
    }

    public UserResponse toResponse(User user) {
        if (user == null) return null;
        Set<RoleResponse> roleResponses = user.getRoles() == null ? null :
                user.getRoles().stream()
                        .map(roleMapper::toResponse)
                        .collect(java.util.stream.Collectors.toSet());
        return new UserResponse(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getEnabled(),
                roleResponses,
                user.getCreatedAt(),
                user.getUpdatedAt()
        );
    }
}