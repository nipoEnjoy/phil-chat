package com.npopov.philharmonic.events.festival.service;

import com.npopov.philharmonic.events.festival.domain.Festival;
import com.npopov.philharmonic.events.festival.repository.FestivalRepository;
import com.npopov.philharmonic.shared.service.JpaCrudService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class FestivalService extends JpaCrudService<Festival, Long> {

    private final FestivalRepository festivalRepository;

    public FestivalService(FestivalRepository festivalRepository) {
        super(festivalRepository);
        this.festivalRepository = festivalRepository;
    }
}
