package com.npopov.philharmonic.events.otherevent.repository;

import com.npopov.philharmonic.events.otherevent.domain.OtherEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtherEventRepository extends JpaRepository<OtherEvent, Long> {
}
