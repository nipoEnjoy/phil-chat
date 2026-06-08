package com.npopov.philharmonic.events.concert.repository;

import com.npopov.philharmonic.events.concert.domain.Concert;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertRepository extends JpaRepository<Concert, Long> {
}
