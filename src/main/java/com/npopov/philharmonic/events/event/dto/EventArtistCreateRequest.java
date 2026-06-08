package com.npopov.philharmonic.events.event.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.math.BigDecimal;

public class EventArtistCreateRequest {
        @NotNull(message = "Event ID is required")
        private Long eventId;

        @NotNull(message = "Artist ID is required")
        private Long artistId;

        @Size(max = 100, message = "Role must not exceed 100 characters")
        private String role;

        private Boolean primaryPerformance;

        private BigDecimal fee;

        public EventArtistCreateRequest(Long eventId, Long artistId, String role, Boolean primaryPerformance, BigDecimal fee) {
                this.eventId = eventId;
                this.artistId = artistId;
                this.role = role;
                this.primaryPerformance = primaryPerformance;
                this.fee = fee;
        }

        public EventArtistCreateRequest(Long artistId, String role, Boolean primaryPerformance, BigDecimal fee) {
                this.artistId = artistId;
                this.role = role;
                this.primaryPerformance = primaryPerformance;
                this.fee = fee;
        }

        public EventArtistCreateRequest() {}

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
}