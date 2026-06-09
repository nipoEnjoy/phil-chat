package com.npopov.philharmonic.events.solo.service;

import com.npopov.philharmonic.events.solo.domain.Solo;
import com.npopov.philharmonic.events.solo.repository.SoloRepository;
import com.npopov.philharmonic.shared.service.JpaCrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SoloService extends JpaCrudService<Solo, Long> {

    private final SoloRepository soloRepository;

    public SoloService(SoloRepository soloRepository) {
        super(soloRepository);
        this.soloRepository = soloRepository;
    }
}
