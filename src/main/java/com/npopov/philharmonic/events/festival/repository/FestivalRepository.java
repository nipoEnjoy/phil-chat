package com.npopov.philharmonic.events.festival.repository;

import com.npopov.philharmonic.events.festival.domain.Festival;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FestivalRepository extends JpaRepository<Festival, Long> {
}
