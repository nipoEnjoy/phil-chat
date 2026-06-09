package com.npopov.philharmonic.events.event.dto;

//import com.npopov.philharmonic.event.domain.EventType;
import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.npopov.philharmonic.events.competition.dto.CompetitionCreateRequest;
import com.npopov.philharmonic.events.concert.dto.ConcertCreateRequest;
import com.npopov.philharmonic.events.festival.dto.FestivalCreateRequest;
import com.npopov.philharmonic.events.otherevent.dto.OtherEventCreateRequest;
import com.npopov.philharmonic.events.solo.dto.SoloCreateRequest;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "eventType"
)
@JsonSubTypes({
        @JsonSubTypes.Type(value = ConcertCreateRequest.class, name = "CONCERT"),
        @JsonSubTypes.Type(value = CompetitionCreateRequest.class, name = "COMPETITION"),
        @JsonSubTypes.Type(value = SoloCreateRequest.class, name = "SOLO"),
        @JsonSubTypes.Type(value = FestivalCreateRequest.class, name = "FESTIVAL"),
        @JsonSubTypes.Type(value = OtherEventCreateRequest.class, name = "OTHER")
})
public abstract class EventCreateRequest {
        @NotBlank(message = "Event title cannot be blank")
        @Size(max = 200, message = "Title must not exceed 200 characters")
        String title;

//        EventType eventType;

        @NotNull(message = "Venue ID is required")
        Long venueId;

        Long organizerId;

        @NotNull(message = "Start datetime is required")
        @Future(message = "Start datetime must be in the future")
        LocalDateTime startDatetime;

        LocalDateTime endDatetime;

        @Size(max = 1000, message = "Description must not exceed 1000 characters")
        String description;

        public EventCreateRequest(String title, Long venueId, Long organizerId, LocalDateTime startDatetime, LocalDateTime endDatetime, String description) {
                this.title = title;
//                this.eventType = eventType;
                this.venueId = venueId;
                this.organizerId = organizerId;
                this.startDatetime = startDatetime;
                this.endDatetime = endDatetime;
                this.description = description;
        }

        public EventCreateRequest() {}

        public String getTitle() {
                return title;
        }

        public void setTitle(String title) {
                this.title = title;
        }
//
//        public EventType getEventType() {
//                return eventType;
//        }
//
//        public void setEventType(EventType eventType) {
//                this.eventType = eventType;
//        }

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
}