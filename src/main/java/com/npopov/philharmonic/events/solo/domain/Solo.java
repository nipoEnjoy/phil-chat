package com.npopov.philharmonic.events.solo.domain;

import com.npopov.philharmonic.events.event.domain.Event;
import com.npopov.philharmonic.organizer.domain.Organizer;
import com.npopov.philharmonic.venues.venue.domain.Venue;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "event_solo")
@DiscriminatorValue("SOLO")
public class Solo extends Event {

    public Solo(String title, Venue venue, Organizer organizer,
                LocalDateTime startDatetime, LocalDateTime endDatetime,
                String description) {
        super(title, venue, organizer, startDatetime, endDatetime, description);
    }

    public Solo() {}
}
