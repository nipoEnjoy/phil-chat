package com.npopov.philharmonic.events.competition.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class CompetitionResultUpdateRequest {
        @NotNull(message = "Competition ID is required")
        Long competitionId;

        @NotNull(message = "Artist ID is required")
        Long artistId;

        Long place;

        @Size(max = 200, message = "Award must not exceed 200 characters")
        String award;

        public CompetitionResultUpdateRequest(Long competitionId, Long artistId, Long place, String award) {
                this.competitionId = competitionId;
                this.artistId = artistId;
                this.place = place;
                this.award = award;
        }

        public CompetitionResultUpdateRequest(Long artistId, Long place, String award) {
                this.artistId = artistId;
                this.place = place;
                this.award = award;
        }

        public CompetitionResultUpdateRequest() {}

        public Long getCompetitionId() {
                return competitionId;
        }

        public void setCompetitionId(Long competitionId) {
                this.competitionId = competitionId;
        }

        public Long getArtistId() {
                return artistId;
        }

        public void setArtistId(Long artistId) {
                this.artistId = artistId;
        }

        public Long getPlace() {
                return place;
        }

        public void setPlace(Long place) {
                this.place = place;
        }

        public String getAward() {
                return award;
        }

        public void setAward(String award) {
                this.award = award;
        }
}