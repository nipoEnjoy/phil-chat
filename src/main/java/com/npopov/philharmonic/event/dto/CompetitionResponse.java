package com.npopov.philharmonic.event.dto;

//import com.npopov.philharmonic.event.domain.EventType;

import java.time.LocalDateTime;

public class CompetitionResponse extends EventResponse {
    private String competitionType;
    private String rules;
    private String juryInfo;

    public CompetitionResponse() {}

    public CompetitionResponse(Long id, String title, Long venueId, Long organizerId,
                               LocalDateTime startDatetime, LocalDateTime endDatetime, String description,
                               LocalDateTime createdAt, LocalDateTime updatedAt,
                               String competitionType, String rules, String juryInfo) {
        super(id, title, venueId, organizerId, startDatetime, endDatetime, description, createdAt, updatedAt);
        this.competitionType = competitionType;
        this.rules = rules;
        this.juryInfo = juryInfo;
    }

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