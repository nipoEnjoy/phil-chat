package com.npopov.philharmonic.identity.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Size;
import java.util.Set;

public class UserUpdateRequest {

    @Size(max = 50, message = "Username must not exceed 50 characters")
    private String username;

    @Email(message = "Email must be valid")
    @Size(max = 100, message = "Email must not exceed 100 characters")
    private String email;

    private Boolean enabled;

    private Set<Long> roleIds;

    public UserUpdateRequest() {}

    public UserUpdateRequest(String username, String email, Boolean enabled, Set<Long> roleIds) {
        this.username = username;
        this.email = email;
        this.enabled = enabled;
        this.roleIds = roleIds;
    }

    public String getUsername() { return username; }
    public void setUsername(String username) { this.username = username; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public Boolean getEnabled() { return enabled; }
    public void setEnabled(Boolean enabled) { this.enabled = enabled; }
    public Set<Long> getRoleIds() { return roleIds; }
    public void setRoleIds(Set<Long> roleIds) { this.roleIds = roleIds; }
}