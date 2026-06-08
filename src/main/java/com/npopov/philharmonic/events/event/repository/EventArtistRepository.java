package com.npopov.philharmonic.events.event.repository;

import com.npopov.philharmonic.events.event.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventArtistRepository extends JpaRepository<Event, Long> {
}
