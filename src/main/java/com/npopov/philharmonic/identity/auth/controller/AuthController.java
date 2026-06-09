package com.npopov.philharmonic.identity.auth.controller;

import com.npopov.philharmonic.identity.auth.dto.RegisterRequest;
import com.npopov.philharmonic.identity.role.domain.Role;
import com.npopov.philharmonic.identity.user.dto.UserMapper;
import com.npopov.philharmonic.identity.user.domain.User;
import com.npopov.philharmonic.shared.security.JwtUtil;
import com.npopov.philharmonic.identity.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;
    private final UserMapper userMapper;

    public AuthController(UserService userService, JwtUtil jwtUtil, UserMapper userMapper) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
        this.userMapper = userMapper;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        Optional<User> userOpt = userService.findByUsername(username);
        if (userOpt.isPresent() && userService.checkPassword(password, userOpt.get().getPassword())) {
            User user = userOpt.get();
            String token = jwtUtil.generateToken(user.getUsername(), user.getRoles());
            List<String> roleNames = user.getRoles().stream()
                    .map(Role::getName)
                    .toList();
            return ResponseEntity.ok(Map.of("token", token, "roles", roleNames));
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        if (userService.findByUsername(req.username()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        User user = userMapper.toUserFromRegister(req);
        User saved = userService.create(user); // create method encodes password
        return ResponseEntity.ok(saved);
    }
}
