package com.npopov.philharmonic.identity.user.controller;

import com.npopov.philharmonic.identity.user.domain.User;
import com.npopov.philharmonic.identity.user.dto.*;
import com.npopov.philharmonic.identity.user.service.UserService;
import com.npopov.philharmonic.shared.controller.GenericRestController;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/users")
@PreAuthorize("hasRole('SUPERADMIN')")
public class UserController {

    private final GenericRestController<User, Long, UserResponse, UserCreateRequest, UserUpdateRequest> genericController;
    private final UserService userService;
    private final UserMapper userMapper;

    public UserController(UserService userService, UserMapper userMapper) {
        this.userService = userService;
        this.userMapper = userMapper;
        this.genericController = new GenericRestController<>(
                userService,
                userMapper::toResponse,
                userMapper::toUserFromCreate,
                (id, req) -> {
                    User user = userMapper.toUserFromUpdate(req);
                    user.setId(id);
                    return user;
                }
        );
    }

    @GetMapping
    public List<UserResponse> getAll() {
        return genericController.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(@PathVariable Long id) {
        return genericController.getById(id);
    }

    @PostMapping
    public ResponseEntity<UserResponse> create(@Valid @RequestBody UserCreateRequest request) {
        return genericController.create(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(@PathVariable Long id, @Valid @RequestBody UserUpdateRequest request) {
        return genericController.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return genericController.delete(id);
    }

    // Назначение ролей пользователю
    @PutMapping("/{id}/roles")
    public ResponseEntity<UserResponse> assignRoles(@PathVariable Long id, @RequestBody Set<Long> roleIds) {
        User updated = userService.assignRoles(id, roleIds);
        return ResponseEntity.ok(userMapper.toResponse(updated));
    }
}