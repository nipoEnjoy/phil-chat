package com.npopov.philharmonic.event.domain;

import com.npopov.philharmonic.organizer.domain.Organizer;
import com.npopov.philharmonic.shared.domain.Auditable;
import com.npopov.philharmonic.shared.domain.HasId;
import com.npopov.philharmonic.venue.domain.Venue;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Table(name = "competition")
@DiscriminatorValue("COMPETITION")
public class Competition extends Event {

    @Column(name = "competition_type")
    private String competitionType;

    @Column(name = "rules")
    private String rules;

    @Column(name = "jury_info")
    private String juryInfo;

    @OneToMany(mappedBy = "competition", fetch = FetchType.LAZY)
    private Set<CompetitionResult> competitionResults;

    public Competition(String title, Venue venue, Organizer organizer,
                       LocalDateTime startDatetime, LocalDateTime endDatetime,
                       String description, String competitionType,
                       String rules, String juryInfo) {
        super(title, venue, organizer, startDatetime, endDatetime, description);  // event
        this.competitionType = competitionType;
        this.rules = rules;
        this.juryInfo = juryInfo;
    }

    public Competition() {}

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

    public Set<CompetitionResult> getCompetitionResults() {
        return competitionResults;
    }

    public void setCompetitionResults(Set<CompetitionResult> competitionResults) {
        this.competitionResults = competitionResults;
    }
}