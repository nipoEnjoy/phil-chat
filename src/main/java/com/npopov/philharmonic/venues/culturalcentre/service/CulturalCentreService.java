package com.npopov.philharmonic.venues.culturalcentre.service;

import com.npopov.philharmonic.shared.service.JpaCrudService;
import com.npopov.philharmonic.venues.culturalcentre.domain.CulturalCentre;
import com.npopov.philharmonic.venues.culturalcentre.repository.CulturalCentreRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CulturalCentreService extends JpaCrudService<CulturalCentre, Long> {

    private final CulturalCentreRepository culturalCentreRepository;

    public CulturalCentreService(CulturalCentreRepository repository, CulturalCentreRepository culturalCentreRepository) {
        super(repository);
        this.culturalCentreRepository = culturalCentreRepository;
    }
}
