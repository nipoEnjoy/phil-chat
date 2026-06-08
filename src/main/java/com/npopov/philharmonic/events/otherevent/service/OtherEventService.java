package com.npopov.philharmonic.events.otherevent.service;

import com.npopov.philharmonic.events.otherevent.domain.OtherEvent;
import com.npopov.philharmonic.events.otherevent.repository.OtherEventRepository;
import com.npopov.philharmonic.shared.service.JpaCrudService;
import org.springframework.stereotype.Service;

@Service
public class OtherEventService extends JpaCrudService<OtherEvent, Long> {

    private final OtherEventRepository repository;

    public OtherEventService(OtherEventRepository repository) {
        super(repository);
        this.repository = repository;
    }
}
