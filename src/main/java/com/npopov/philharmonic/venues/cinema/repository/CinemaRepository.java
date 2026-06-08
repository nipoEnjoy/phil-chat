package com.npopov.philharmonic.venues.cinema.repository;

import com.npopov.philharmonic.venues.cinema.domain.Cinema;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CinemaRepository extends JpaRepository<Cinema, Long> {
}
