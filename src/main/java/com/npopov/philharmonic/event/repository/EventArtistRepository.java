package com.npopov.philharmonic.event.repository;

import com.npopov.philharmonic.event.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventArtistRepository extends JpaRepository<Event, Long> {
}
