package com.npopov.philharmonic.venues.varietystage.service;

import com.npopov.philharmonic.shared.service.JpaCrudService;
import com.npopov.philharmonic.venues.varietystage.domain.VarietyStage;
import com.npopov.philharmonic.venues.varietystage.repository.VarietyStageRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class VarietyStageService extends JpaCrudService<VarietyStage, Long> {

    private final VarietyStageRepository varietyStageRepository;

    public VarietyStageService(JpaRepository<VarietyStage, Long> repository, VarietyStageRepository varietyStageRepository) {
        super(repository);
        this.varietyStageRepository = varietyStageRepository;
    }
}
