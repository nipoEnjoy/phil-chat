package com.npopov.philharmonic.venues.concert.repository;

import com.npopov.philharmonic.venues.concert.domain.ConcertVenue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConcertVenueRepository  extends JpaRepository<ConcertVenue, Long> {
}
