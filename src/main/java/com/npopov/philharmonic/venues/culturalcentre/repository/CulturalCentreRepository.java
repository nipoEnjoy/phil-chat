package com.npopov.philharmonic.venues.culturalcentre.repository;

import com.npopov.philharmonic.venues.cinema.domain.Cinema;
import com.npopov.philharmonic.venues.culturalcentre.domain.CulturalCentre;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CulturalCentreRepository  extends JpaRepository<CulturalCentre, Long> {
}
