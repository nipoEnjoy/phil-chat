package com.npopov.philharmonic.events.competition.domain;

import com.npopov.philharmonic.artist.domain.Artist;
import com.npopov.philharmonic.shared.domain.Auditable;
import com.npopov.philharmonic.shared.domain.HasId;
import jakarta.persistence.*;

@Entity
@Table(name = "competition_result", uniqueConstraints = @UniqueConstraint(columnNames = {"competition_id", "artist_id"}))
public class CompetitionResult extends Auditable implements HasId<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "competition_id", nullable = false)
    private Competition competition;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @Column(name = "place")
    private Integer place;

    @Column(name = "award")
    private String award;

    public CompetitionResult() {}

    public CompetitionResult(Competition competition, Artist artist, Integer place, String award) {
        this.competition = competition;
        this.artist = artist;
        this.place = place;
        this.award = award;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Competition getCompetition() {
        return competition;
    }

    public void setCompetition(Competition competition) {
        this.competition = competition;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Integer getPlace() {
        return place;
    }

    public void setPlace(Integer place) {
        this.place = place;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }
}