package com.npopov.philharmonic.artist.repository;

import com.npopov.philharmonic.artist.domain.Artist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ArtistRepository extends JpaRepository<Artist, Long> {
    List<Artist> findByArtistGenres_Genre_Name(String genreName);
    List<Artist> findByArtistImpresarios_Impresario_Id(Long impresarioId);

    @Query("SELECT a FROM Artist a WHERE SIZE(a.artistGenres) > 1")
    List<Artist> findArtistsWithMultipleGenres();
}