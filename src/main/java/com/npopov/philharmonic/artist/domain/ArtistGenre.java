package com.npopov.philharmonic.artist.domain;

import com.npopov.philharmonic.genre.domain.Genre;
import com.npopov.philharmonic.shared.domain.Auditable;
import com.npopov.philharmonic.shared.domain.HasId;
import jakarta.persistence.*;

@Entity
@Table(name = "artist_genre", uniqueConstraints = @UniqueConstraint(columnNames = {"artist_id", "genre_id"}))
public class ArtistGenre extends Auditable implements HasId<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "genre_id", nullable = false)
    private Genre genre;

    public ArtistGenre() {}

    public ArtistGenre(Artist artist, Genre genre) {
        this.artist = artist;
        this.genre = genre;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Artist getArtist() {
        return artist;
    }

    public void setArtist(Artist artist) {
        this.artist = artist;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }
}