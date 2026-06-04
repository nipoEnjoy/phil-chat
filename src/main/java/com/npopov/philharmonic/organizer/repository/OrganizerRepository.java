package com.npopov.philharmonic.organizer.repository;

import com.npopov.philharmonic.organizer.domain.Organizer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrganizerRepository extends JpaRepository<Organizer, Long> {
}