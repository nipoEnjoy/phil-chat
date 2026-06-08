package com.npopov.philharmonic.events.otherevent.domain;

import com.npopov.philharmonic.events.event.domain.Event;
import com.npopov.philharmonic.organizer.domain.Organizer;
import com.npopov.philharmonic.venues.venue.domain.Venue;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "other_event")
@DiscriminatorValue("OTHER")
public class OtherEvent extends Event {

    public OtherEvent(String title, Venue venue, Organizer organizer,
                      LocalDateTime startDatetime, LocalDateTime endDatetime,
                      String description) {
        super(title, venue, organizer, startDatetime, endDatetime, description);
    }

    public OtherEvent() {}
}
