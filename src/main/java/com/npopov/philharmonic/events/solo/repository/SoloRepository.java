package com.npopov.philharmonic.events.solo.repository;

import com.npopov.philharmonic.events.solo.domain.Solo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoloRepository extends JpaRepository<Solo, Long> {
}
