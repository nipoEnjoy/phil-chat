package com.npopov.philharmonic.shared.security;

import com.npopov.philharmonic.identity.user.domain.Role;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Set;
import java.util.stream.Collectors;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "mySecretKeyForJwtThatIsLongEnoughToBeSecure12345678901234567890";  // Use env variable in prod
    private static final long EXPIRATION_TIME = 86400000;  // 1 day

    private final Key key = Keys.hmacShaKeyFor(SECRET_KEY.getBytes());

    public String generateToken(String username, Set<Role> roles) {
        return Jwts.builder()
                .setSubject(username)
                .claim("roles", roles.stream().map(Enum::name).collect(Collectors.toList()))
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(key, SignatureAlgorithm.HS256)
                .compact();
    }

    public String extractUsername(String token) {
        return extractClaims(token).getSubject();
    }

    public Set<Role> extractRoles(String token) {
        Claims claims = extractClaims(token);
        return ((java.util.List<String>) claims.get("roles")).stream()
                .map(Role::valueOf)
                .collect(Collectors.toSet());
    }

    public boolean isTokenValid(String token) {
        try {
            extractClaims(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private Claims extractClaims(String token) {
        return Jwts.parser()
                .setSigningKey(key)
                .build()
                .parseSignedClaims(token)
                .getPayload();
    }
}