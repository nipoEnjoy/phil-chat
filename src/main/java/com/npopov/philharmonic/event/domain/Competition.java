package com.npopov.philharmonic.event.domain;

import com.npopov.philharmonic.shared.domain.Auditable;
import com.npopov.philharmonic.shared.domain.HasId;
import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "competition")
@PrimaryKeyJoinColumn(name = "id")
public class Competition extends Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false, unique = true)
    private Event event;

    @Column(name = "competition_type")
    private String competitionType;

    @Column(name = "rules")
    private String rules;

    @Column(name = "jury_info")
    private String juryInfo;

    @OneToMany(mappedBy = "competition", fetch = FetchType.LAZY)
    private Set<CompetitionResult> competitionResults;

    public Competition() {}

    public Competition(Event event, String competitionType, String rules, String juryInfo) {
        this.event = event;
        this.competitionType = competitionType;
        this.rules = rules;
        this.juryInfo = juryInfo;
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