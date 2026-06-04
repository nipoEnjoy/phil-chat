package com.npopov.philharmonic.artist.domain;

import com.npopov.philharmonic.impresario.domain.Impresario;
import com.npopov.philharmonic.shared.domain.Auditable;
import com.npopov.philharmonic.shared.domain.HasId;
import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "artist_impresario", uniqueConstraints = @UniqueConstraint(columnNames = {"artist_id", "impresario_id", "start_date"}))
public class ArtistImpresario extends Auditable implements HasId<Long> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "artist_id", nullable = false)
    private Artist artist;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "impresario_id", nullable = false)
    private Impresario impresario;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "end_date")
    private LocalDate endDate;

    public ArtistImpresario() {}

    public ArtistImpresario(Artist artist, Impresario impresario, LocalDate startDate, LocalDate endDate) {
        this.artist = artist;
        this.impresario = impresario;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public Impresario getImpresario() {
        return impresario;
    }

    public void setImpresario(Impresario impresario) {
        this.impresario = impresario;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }
}