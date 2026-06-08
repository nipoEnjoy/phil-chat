package com.npopov.philharmonic.events.event.domain;

import com.npopov.philharmonic.artist.domain.Artist;
import com.npopov.philharmonic.shared.domain.Auditable;
import com.npopov.philharmonic.shared.domain.HasId;
import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "event_artist", uniqueConstraints = @UniqueConstraint(columnNames = {"event_id", "artist_id"}))
public class EventArtist extends Auditable implements HasId<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @Column(name = "role")
    private String role;

    @Column(name = "primary_performance")
    private Boolean primaryPerformance;

    @Column(name = "fee")
    private BigDecimal fee;

    public EventArtist() {}

    public EventArtist(Event event, Artist artist, String role, Boolean primaryPerformance, BigDecimal fee) {
        this.event = event;
        this.artist = artist;
        this.role = role;
        this.primaryPerformance = primaryPerformance;
        this.fee = fee;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Boolean getPrimaryPerformance() {
        return primaryPerformance;
    }

    public void setPrimaryPerformance(Boolean primaryPerformance) {
        this.primaryPerformance = primaryPerformance;
    }

    public BigDecimal getFee() {
        return fee;
    }

    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }
}