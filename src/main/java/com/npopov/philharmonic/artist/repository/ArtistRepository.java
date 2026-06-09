package com.npopov.philharmonic.artist.repository;

import com.npopov.philharmonic.artist.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findByArtistGenres_Genre_Name(String genreName);
    List<Artist> findByArtistImpresarios_Impresario_Id(Long impresarioId);

    @Query("SELECT a FROM Artist a WHERE SIZE(a.artistGenres) > 1")
    List<Artist> findArtistsWithMultipleGenres();

    // Artist with no competitions in period
    @Query("SELECT a FROM Artist a " +
            "WHERE a.id NOT IN " +
            "(SELECT cr.artist.id FROM CompetitionResult " +
            "cr WHERE cr.competition.startDatetime BETWEEN :start AND :end)")
    List<Artist> findArtistsWithoutCompetitionsInPeriod(@Param("start") LocalDateTime start, @Param("end") LocalDateTime end);

    // Find by genres
    @Query("SELECT DISTINCT a FROM Artist a " +
            "LEFT JOIN FETCH a.artistGenres ag " +
            "LEFT JOIN FETCH ag.genre " +
            "WHERE a.id = :id")
    Optional<Artist> findByIdWithGenres(Long id);

    @Query("SELECT DISTINCT a FROM Artist a " +
            "LEFT JOIN FETCH a.artistGenres ag " +
            "LEFT JOIN FETCH ag.genre")
    List<Artist> findAllWithGenres();
}