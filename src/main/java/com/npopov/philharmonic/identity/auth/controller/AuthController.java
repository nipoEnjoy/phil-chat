package com.npopov.philharmonic.identity.auth.controller;

import com.npopov.philharmonic.identity.auth.dto.RegisterRequest;
import com.npopov.philharmonic.identity.user.dto.UserMapper;
import com.npopov.philharmonic.identity.user.domain.User;
import com.npopov.philharmonic.shared.security.JwtUtil;
import com.npopov.philharmonic.identity.user.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService, JwtUtil jwtUtil) {
        this.userService = userService;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody Map<String, String> loginRequest) {
        String username = loginRequest.get("username");
        String password = loginRequest.get("password");

        Optional<User> userOpt = userService.findByUsername(username);
        if (userOpt.isPresent() && userService.checkPassword(password, userOpt.get().getPassword())) {
            User user = userOpt.get();
            String token = jwtUtil.generateToken(user.getUsername(), user.getRoles());
            return ResponseEntity.ok(Map.of("token", token, "roles", user.getRoles()));
        }
        return ResponseEntity.status(401).body("Invalid credentials");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        if (userService.findByUsername(req.username()).isPresent()) {
            return ResponseEntity.badRequest().body("Username already exists");
        }
        User user = UserMapper.toUser(req);
        User saved = userService.save(user); // save encodes password
        return ResponseEntity.ok(saved);
    }
}
