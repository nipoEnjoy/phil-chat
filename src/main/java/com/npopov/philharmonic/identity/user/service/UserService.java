package com.npopov.philharmonic.identity.user.service;

import com.npopov.philharmonic.identity.user.domain.User;
import com.npopov.philharmonic.identity.user.repository.UserRepository;
import com.npopov.philharmonic.shared.service.JpaCrudService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService extends JpaCrudService<User, Long> {

    Logger logger = LoggerFactory.getLogger(UserService.class);

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        super(userRepository);
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public boolean checkPassword(String rawPassword, String encodedPassword) {
        logger.debug("Checking password for user: {}, {}", rawPassword, encodedPassword);
        return passwordEncoder.matches(rawPassword, encodedPassword);
    }
}