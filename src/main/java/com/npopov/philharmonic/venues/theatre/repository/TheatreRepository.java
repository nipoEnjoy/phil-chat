package com.npopov.philharmonic.venues.theatre.repository;

import com.npopov.philharmonic.venues.theatre.domain.Theatre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TheatreRepository  extends JpaRepository<Theatre, Long> {
}
