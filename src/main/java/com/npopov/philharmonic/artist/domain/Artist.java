package com.npopov.philharmonic.artist.domain;

import com.npopov.philharmonic.events.competition.domain.CompetitionResult;
import com.npopov.philharmonic.events.event.domain.EventArtist;
import com.npopov.philharmonic.genre.domain.Genre;
import com.npopov.philharmonic.shared.domain.Auditable;
import com.npopov.philharmonic.shared.domain.HasId;
import jakarta.persistence.*;

import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;

@Entity
@Table(name = "artist")
public class Artist extends Auditable implements HasId<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", length = 100)
    private String lastName;

    @Column(name = "stage_name", length = 100)
    private String stageName;

    @Column(name = "contact_info", length = 200)
    private String contactInfo;

    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
    private Set<ArtistGenre> artistGenres;

    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
    private Set<ArtistImpresario> artistImpresarios;

    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
    private Set<EventArtist> eventArtists;

    @OneToMany(mappedBy = "artist", fetch = FetchType.LAZY)
    private Set<CompetitionResult> competitionResults;

    public Artist() {}

    public Artist(String firstName, String lastName, String stageName, String contactInfo) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.stageName = stageName;
        this.contactInfo = contactInfo;
    }

    public Set<Genre> getGenres() {
        if (artistGenres == null || artistGenres.isEmpty()) {
            return Collections.emptySet();
        }
        return artistGenres.stream()
                .map(ArtistGenre::getGenre)
                .collect(Collectors.toSet());
    }

    public void addGenre(Genre genre) {
        if (artistGenres == null) {
            artistGenres = new java.util.HashSet<>();
        }
        boolean exists = artistGenres.stream()
                .anyMatch(ag -> ag.getGenre().getId().equals(genre.getId()));
        if (!exists) {
            ArtistGenre link = new ArtistGenre(this, genre);
            artistGenres.add(link);
        }
    }

    public void removeGenre(Genre genre) {
        if (artistGenres != null) {
            artistGenres.removeIf(ag -> ag.getGenre().getId().equals(genre.getId()));
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStageName() {
        return stageName;
    }

    public void setStageName(String stageName) {
        this.stageName = stageName;
    }

    public String getContactInfo() {
        return contactInfo;
    }

    public void setContactInfo(String contactInfo) {
        this.contactInfo = contactInfo;
    }

    public Set<ArtistGenre> getArtistGenres() {
        return artistGenres;
    }

    public void setArtistGenres(Set<ArtistGenre> artistGenres) {
        this.artistGenres = artistGenres;
    }

    public Set<ArtistImpresario> getArtistImpresarios() {
        return artistImpresarios;
    }

    public void setArtistImpresarios(Set<ArtistImpresario> artistImpresarios) {
        this.artistImpresarios = artistImpresarios;
    }

    public Set<EventArtist> getEventArtists() {
        return eventArtists;
    }

    public void setEventArtists(Set<EventArtist> eventArtists) {
        this.eventArtists = eventArtists;
    }

    public Set<CompetitionResult> getCompetitionResults() {
        return competitionResults;
    }

    public void setCompetitionResults(Set<CompetitionResult> competitionResults) {
        this.competitionResults = competitionResults;
    }
}