package com.npopov.philharmonic.identity.role.controller;

import com.npopov.philharmonic.identity.role.domain.Role;
import com.npopov.philharmonic.identity.role.dto.RoleCreateRequest;
import com.npopov.philharmonic.identity.role.dto.RoleMapper;
import com.npopov.philharmonic.identity.role.dto.RoleResponse;
import com.npopov.philharmonic.identity.role.dto.RoleUpdateRequest;
import com.npopov.philharmonic.identity.role.service.RoleService;
import com.npopov.philharmonic.shared.controller.GenericRestController;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/roles")
@PreAuthorize("hasRole('SUPERADMIN')")
public class RoleController {

    private final GenericRestController<Role, Long, RoleResponse, RoleCreateRequest, RoleUpdateRequest> genericController;

    public RoleController(RoleService roleService, RoleMapper roleMapper) {
        this.genericController = new GenericRestController<>(
                roleService,
                roleMapper::toResponse,
                roleMapper::toRoleFromCreate,
                (id, req) -> {
                    Role role = roleMapper.toRoleFromUpdate(req);
                    role.setId(id);
                    return role;
                }
        );
    }

    @GetMapping
    public List<RoleResponse> getAll() {
        return genericController.getAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<RoleResponse> getById(@PathVariable Long id) {
        return genericController.getById(id);
    }

    @PostMapping
    public ResponseEntity<RoleResponse> create(@Valid @RequestBody RoleCreateRequest request) {
        return genericController.create(request);
    }

    @PutMapping("/{id}")
    public ResponseEntity<RoleResponse> update(@PathVariable Long id, @Valid @RequestBody RoleUpdateRequest request) {
        return genericController.update(id, request);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        return genericController.delete(id);
    }
}