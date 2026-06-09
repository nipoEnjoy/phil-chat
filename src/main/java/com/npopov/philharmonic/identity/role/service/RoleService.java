package com.npopov.philharmonic.identity.role.service;

import com.npopov.philharmonic.identity.role.domain.Role;
import com.npopov.philharmonic.identity.role.repository.RoleRepository;
import com.npopov.philharmonic.shared.service.JpaCrudService;
import org.springframework.stereotype.Service;

@Service
public class RoleService extends JpaCrudService<Role, Long> {

    private final RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        super(roleRepository);
        this.roleRepository = roleRepository;
    }
}