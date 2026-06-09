package com.npopov.philharmonic.events.event.repository;

import com.npopov.philharmonic.events.event.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findByStartDatetimeBetween(LocalDateTime start, LocalDateTime end);
    List<Event> findByOrganizer_Id(Long organizerId);
    List<Event> findByVenue_Id(Long venueId);

    @Query("SELECT e.organizer.id, e.organizer.name, " +
            "COUNT(e) FROM Event e " +
            "WHERE e.eventType = 'CONCERT' " +
            "AND e.startDatetime BETWEEN :start AND :end " +
            "GROUP BY e.organizer.id, e.organizer.name")
    List<Object[]> countConcertsByOrganizerInPeriod(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    @Query("SELECT v.id, v.name, e.id, e.title, e.startDatetime " +
            "FROM Venue v JOIN v.events e " +
            "WHERE e.startDatetime BETWEEN :start AND :end " +
            "ORDER BY v.id, e.startDatetime")
    List<Object[]> findVenuesWithEventsInPeriod(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);
}