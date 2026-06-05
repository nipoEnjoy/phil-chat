package com.npopov.philharmonic.event.domain;

import com.npopov.philharmonic.organizer.domain.Organizer;
import com.npopov.philharmonic.venue.domain.Venue;
import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDateTime;

@Entity
@Table(name = "concert")
@DiscriminatorValue("CONCERT")
public class Concert extends Event {

    @Column(name = "program")
    private String program;

    public Concert(String title, Venue venue, Organizer organizer,
                   LocalDateTime startDatetime, LocalDateTime endDatetime,
                   String description, String program) {
        super(title, venue, organizer, startDatetime, endDatetime, description);
        this.program = program;
    }

    public Concert() {}

    public String getProgram() {
        return program;
    }

    public void setProgram(String program) {
        this.program = program;
    }
}
