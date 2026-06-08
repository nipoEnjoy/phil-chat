package com.npopov.philharmonic.events.competition.dto;

import com.npopov.philharmonic.events.event.dto.EventCreateRequest;
import jakarta.validation.constraints.Size;

import java.time.LocalDateTime;

public class CompetitionUpdateRequest extends EventCreateRequest {
        @Size(max = 100, message = "Competition type must not exceed 100 characters")
        String competitionType;

        @Size(max = 1000, message = "Rules must not exceed 1000 characters")
        String rules;

        @Size(max = 500, message = "Jury info must not exceed 500 characters")
        String juryInfo;

        public CompetitionUpdateRequest(String title, Long venueId, Long organizerId, LocalDateTime startDatetime, LocalDateTime endDatetime, String description, String competitionType, String rules, String juryInfo) {
                super(title, venueId, organizerId, startDatetime, endDatetime, description);
                this.competitionType = competitionType;
                this.rules = rules;
                this.juryInfo = juryInfo;
        }

        public CompetitionUpdateRequest(String competitionType, String rules, String juryInfo) {
                this.competitionType = competitionType;
                this.rules = rules;
                this.juryInfo = juryInfo;
        }

        public CompetitionUpdateRequest() {}

        public String getCompetitionType() {
                return competitionType;
        }

        public void setCompetitionType(String competitionType) {
                this.competitionType = competitionType;
        }

        public String getRules() {
                return rules;
        }

        public void setRules(String rules) {
                this.rules = rules;
        }

        public String getJuryInfo() {
                return juryInfo;
        }

        public void setJuryInfo(String juryInfo) {
                this.juryInfo = juryInfo;
        }
}