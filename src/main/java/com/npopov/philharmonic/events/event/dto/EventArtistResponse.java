package com.npopov.philharmonic.events.event.dto;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class EventArtistResponse {
    private Long id;
    private Long eventId;
    private Long artistId;
    private String role;
    private Boolean primaryPerformance;
    private BigDecimal fee;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public EventArtistResponse(Long id, Long eventId, Long artistId, String role, Boolean primaryPerformance, BigDecimal fee, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.eventId = eventId;
        this.artistId = artistId;
        this.role = role;
        this.primaryPerformance = primaryPerformance;
        this.fee = fee;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public EventArtistResponse(Long eventId, Long artistId, String role, Boolean primaryPerformance, BigDecimal fee, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.eventId = eventId;
        this.artistId = artistId;
        this.role = role;
        this.primaryPerformance = primaryPerformance;
        this.fee = fee;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public EventArtistResponse() {}

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEventId() {
        return eventId;
    }

    public void setEventId(Long eventId) {
        this.eventId = eventId;
    }

    public Long getArtistId() {
        return artistId;
    }

    public void setArtistId(Long artistId) {
        this.artistId = artistId;
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }
}