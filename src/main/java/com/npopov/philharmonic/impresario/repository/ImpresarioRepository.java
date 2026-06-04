package com.npopov.philharmonic.impresario.repository;

import com.npopov.philharmonic.impresario.domain.Impresario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ImpresarioRepository extends JpaRepository<Impresario, Long> {
    List<Impresario> findByArtistImpresarios_Artist_Id(Long artistId);

    @Query("SELECT DISTINCT i FROM Impresario i JOIN i.artistImpresarios ai JOIN ai.artist a JOIN a.artistGenres ag WHERE ag.genre.name = :genreName")
    List<Impresario> findByGenre(String genreName);
}