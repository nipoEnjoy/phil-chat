package com.npopov.philharmonic.events.festival.domain;

import com.npopov.philharmonic.events.event.domain.Event;
import com.npopov.philharmonic.organizer.domain.Organizer;
import com.npopov.philharmonic.venues.venue.domain.Venue;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "festival")
@DiscriminatorValue("FESTIVAL")
public class Festival extends Event {

    public Festival(String title, Venue venue, Organizer organizer,
                    LocalDateTime startDatetime, LocalDateTime endDatetime,
                    String description) {
        super(title, venue, organizer, startDatetime, endDatetime, description);
    }

    public Festival() {}
}
