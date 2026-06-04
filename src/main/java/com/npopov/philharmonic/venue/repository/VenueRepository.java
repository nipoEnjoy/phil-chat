package com.npopov.philharmonic.venue.repository;

import com.npopov.philharmonic.venue.domain.Venue;
import com.npopov.philharmonic.venue.domain.VenueType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VenueRepository extends JpaRepository<Venue, Long> {
    List<Venue> findByVenueType(VenueType venueType);
}