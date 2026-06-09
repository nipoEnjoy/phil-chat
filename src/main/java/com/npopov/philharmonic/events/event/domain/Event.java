package com.npopov.philharmonic.events.event.domain;

import com.npopov.philharmonic.organizer.domain.Organizer;
import com.npopov.philharmonic.shared.domain.HasId;
import com.npopov.philharmonic.venues.venue.domain.Venue;
import com.npopov.philharmonic.shared.domain.Auditable;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "event")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "event_type", discriminatorType = DiscriminatorType.STRING)
public class Event extends Auditable implements HasId<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "title", nullable = false, length = 200)
    private String title;

    @Enumerated(EnumType.STRING)
    @Column(name = "event_type", nullable = false, insertable = false, updatable = false)
    private EventType eventType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "venue_id", nullable = false)
    private Venue venue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organizer_id")
    private Organizer organizer;

    @Column(name = "start_datetime", nullable = false)
    private LocalDateTime startDatetime;

    @Column(name = "end_datetime")
    private LocalDateTime endDatetime;

    @Column(name = "description", length = 1000)
    private String description;

    @OneToMany(mappedBy = "event", fetch = FetchType.LAZY)
    private Set<EventArtist> eventArtists;

    public Event() {}

    public Event(String title, Venue venue, Organizer organizer, LocalDateTime startDatetime, LocalDateTime endDatetime, String description) {
        this.title = title;
//        this.eventType = eventType;
        this.venue = venue;
        this.organizer = organizer;
        this.startDatetime = startDatetime;
        this.endDatetime = endDatetime;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
//
//    public EventType getEventType() {
//        return eventType;
//    }
//
//    public void setEventType(EventType eventType) {
//        this.eventType = eventType;
//    }

    public Venue getVenue() {
        return venue;
    }

    public void setVenue(Venue venue) {
        this.venue = venue;
    }

    public Organizer getOrganizer() {
        return organizer;
    }

    public void setOrganizer(Organizer organizer) {
        this.organizer = organizer;
    }

    public LocalDateTime getStartDatetime() {
        return startDatetime;
    }

    public void setStartDatetime(LocalDateTime startDatetime) {
        this.startDatetime = startDatetime;
    }

    public LocalDateTime getEndDatetime() {
        return endDatetime;
    }

    public void setEndDatetime(LocalDateTime endDatetime) {
        this.endDatetime = endDatetime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<EventArtist> getEventArtists() {
        return eventArtists;
    }

    public void setEventArtists(Set<EventArtist> eventArtists) {
        this.eventArtists = eventArtists;
    }
}