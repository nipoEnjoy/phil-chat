package com.npopov.philharmonic.genre.domain;

import com.npopov.philharmonic.artist.domain.ArtistGenre;
import com.npopov.philharmonic.shared.domain.Auditable;
import com.npopov.philharmonic.shared.domain.HasId;
import jakarta.persistence.*;
import java.util.Set;

@Entity
@Table(name = "genre")
public class Genre extends Auditable implements HasId<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false, unique = true, length = 100)
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "genre", fetch = FetchType.LAZY)
    private Set<ArtistGenre> artistGenres;

    public Genre() {}

    public Genre(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<ArtistGenre> getArtistGenres() {
        return artistGenres;
    }

    public void setArtistGenres(Set<ArtistGenre> artistGenres) {
        this.artistGenres = artistGenres;
    }
}