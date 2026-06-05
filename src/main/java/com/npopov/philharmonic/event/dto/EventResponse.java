package com.npopov.philharmonic.event.dto;

//import com.npopov.philharmonic.event.domain.EventType;
import com.npopov.philharmonic.organizer.dto.OrganizerResponse;
import com.npopov.philharmonic.shared.domain.HasId;
import com.npopov.philharmonic.venue.dto.VenueResponse;

import java.time.LocalDateTime;

public class EventResponse {
    private Long id;
    private String title;
//    private EventType eventType;
    private Long venueId;
    private Long organizerId;
    private LocalDateTime startDatetime;
    private LocalDateTime endDatetime;
    private String description;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    public EventResponse() {}

    public EventResponse(Long id, String title, Long venueId, Long organizerId, LocalDateTime startDatetime, LocalDateTime endDatetime, String description, LocalDateTime createdAt, LocalDateTime updatedAt) {
        this.id = id;
        this.title = title;
//        this.eventType = eventType;
        this.venueId = venueId;
        this.organizerId = organizerId;
        this.startDatetime = startDatetime;
        this.endDatetime = endDatetime;
        this.description = description;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
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

//    public EventType getEventType() {
//        return eventType;
//    }
//
//    public void setEventType(EventType eventType) {
//        this.eventType = eventType;
//    }

    public Long getVenueId() {
        return venueId;
    }

    public void setVenueId(Long venueId) {
        this.venueId = venueId;
    }

    public Long getOrganizerId() {
        return organizerId;
    }

    public void setOrganizerId(Long organizerId) {
        this.organizerId = organizerId;
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