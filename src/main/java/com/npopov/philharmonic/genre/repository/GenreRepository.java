package com.npopov.philharmonic.genre.repository;

import com.npopov.philharmonic.genre.domain.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenreRepository extends JpaRepository<Genre, Long> {
}