package com.npopov.philharmonic.venues.venue.service;

import com.npopov.philharmonic.venues.cinema.domain.Cinema;
import com.npopov.philharmonic.venues.cinema.dto.CinemaCreateRequest;
import com.npopov.philharmonic.venues.cinema.dto.CinemaMapper;
import com.npopov.philharmonic.venues.cinema.dto.CinemaUpdateRequest;
import com.npopov.philharmonic.venues.concert.domain.ConcertVenue;
import com.npopov.philharmonic.venues.concert.dto.ConcertVenueCreateRequest;
import com.npopov.philharmonic.venues.concert.dto.ConcertVenueMapper;
import com.npopov.philharmonic.venues.concert.dto.ConcertVenueUpdateRequest;
import com.npopov.philharmonic.venues.culturalcentre.domain.CulturalCentre;
import com.npopov.philharmonic.venues.culturalcentre.dto.CulturalCentreCreateRequest;
import com.npopov.philharmonic.venues.culturalcentre.dto.CulturalCentreMapper;
import com.npopov.philharmonic.venues.culturalcentre.dto.CulturalCentreUpdateRequest;
import com.npopov.philharmonic.venues.theatre.domain.Theatre;
import com.npopov.philharmonic.venues.theatre.dto.TheatreCreateRequest;
import com.npopov.philharmonic.venues.theatre.dto.TheatreMapper;
import com.npopov.philharmonic.venues.theatre.dto.TheatreUpdateRequest;
import com.npopov.philharmonic.venues.varietystage.domain.VarietyStage;
import com.npopov.philharmonic.venues.varietystage.dto.VarietyStageCreateRequest;
import com.npopov.philharmonic.venues.varietystage.dto.VarietyStageMapper;
import com.npopov.philharmonic.venues.varietystage.dto.VarietyStageUpdateRequest;
import com.npopov.philharmonic.venues.venue.domain.Venue;
import com.npopov.philharmonic.venues.venue.domain.VenueType;
import com.npopov.philharmonic.venues.venue.dto.VenueCreateRequest;
import com.npopov.philharmonic.venues.venue.dto.VenueResponse;
import com.npopov.philharmonic.venues.venue.dto.VenueUpdateRequest;
import com.npopov.philharmonic.venues.venue.repository.VenueRepository;
import com.npopov.philharmonic.shared.service.JpaCrudService;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VenueService extends JpaCrudService<Venue, Long> {

    private final VenueRepository venueRepository;

    private final TheatreMapper theatreMapper;
    private final CinemaMapper cinemaMapper;
    private final ConcertVenueMapper concertVenueMapper;
    private final VarietyStageMapper varietyStageMapper;
    private final CulturalCentreMapper culturalCentreMapper;

    public VenueService(VenueRepository venueRepository,
                        TheatreMapper theatreMapper,
                        CinemaMapper cinemaMapper,
                        ConcertVenueMapper concertVenueMapper,
                        VarietyStageMapper varietyStageMapper,
                        CulturalCentreMapper culturalCentreMapper) {
        super(venueRepository);
        this.venueRepository = venueRepository;
        this.theatreMapper = theatreMapper;
        this.cinemaMapper = cinemaMapper;
        this.concertVenueMapper = concertVenueMapper;
        this.varietyStageMapper = varietyStageMapper;
        this.culturalCentreMapper = culturalCentreMapper;
    }

    @Override
    public List<Venue> getAll() {
        return venueRepository.findAll();
    }

    @Override
    public Optional<Venue> findById(Long id) {
        return venueRepository.findById(id);
    }

    public List<Venue> findByVenueType(VenueType type) {
        return venueRepository.findByVenueType(type);
    }

    @Transactional
    public Venue createFromRequest(VenueCreateRequest request) {
        Venue venue = switch (request) {
            case TheatreCreateRequest req -> theatreMapper.toTheatreFromCreate(req);
            case CinemaCreateRequest req -> cinemaMapper.toCinemaFromCreate(req);
            case ConcertVenueCreateRequest req -> concertVenueMapper.toConcertVenueFromCreate(req);
            case VarietyStageCreateRequest req -> varietyStageMapper.toVarietyStageFromCreate(req);
            case CulturalCentreCreateRequest req -> culturalCentreMapper.toCulturalCentreFromCreate(req);
            default -> throw new IllegalArgumentException("Unknown venue type: " + request.getClass());
        };
        return venueRepository.save(venue);
    }

    @Transactional
    public Venue updateFromRequest(VenueUpdateRequest request) {
        Venue venue = switch (request) {
            case TheatreUpdateRequest req -> theatreMapper.toTheatreFromUpdate(req);
            case CinemaUpdateRequest req -> cinemaMapper.toCinemaFromUpdate(req);
            case ConcertVenueUpdateRequest req -> concertVenueMapper.toConcertVenueFromUpdate(req);
            case VarietyStageUpdateRequest req -> varietyStageMapper.toVarietyStageFromUpdate(req);
            case CulturalCentreUpdateRequest req -> culturalCentreMapper.toCulturalCentreFromUpdate(req);
            default -> throw new IllegalArgumentException("Unknown venue type: " + request.getClass());
        };
        return venue;
    }

    public VenueResponse toResponse(Venue venue) {
        return switch (venue) {
            case Theatre theatre -> theatreMapper.toResponse(theatre);
            case Cinema cinema -> cinemaMapper.toResponse(cinema);
            case ConcertVenue concertVenue -> concertVenueMapper.toResponse(concertVenue);
            case VarietyStage varietyStage -> varietyStageMapper.toResponse(varietyStage);
            case CulturalCentre culturalCentre -> culturalCentreMapper.toResponse(culturalCentre);
            default -> throw new IllegalArgumentException("Unknown venue type: " + venue.getClass());
        };
    }

    @Override
    public void deleteById(Long id) {
        venueRepository.deleteById(id);
    }
}