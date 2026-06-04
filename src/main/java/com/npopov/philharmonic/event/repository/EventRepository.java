package com.npopov.philharmonic.event.repository;

import com.npopov.philharmonic.event.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByStartDatetimeBetween(LocalDateTime start, LocalDateTime end);
    List<Event> findByOrganizer_Id(Long organizerId);
    List<Event> findByVenue_Id(Long venueId);
}