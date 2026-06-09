package com.npopov.philharmonic.reports.controller;

import com.npopov.philharmonic.reports.dto.ArtistNoCompetition;
import com.npopov.philharmonic.reports.dto.OrganizerStat;
import com.npopov.philharmonic.reports.dto.VenueWithEvent;
import com.npopov.philharmonic.reports.service.ReportService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/api/reports")
public class ReportController {

    private final ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @GetMapping("/artists-no-competitions")
    public List<ArtistNoCompetition> getArtistsNoCompetitions(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return reportService.getArtistsWithoutCompetitions(start, end);
    }

    @GetMapping("/organizers-stats")
    public List<OrganizerStat> getOrganizerStats(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return reportService.getOrganizerConcertStats(start, end);
    }

    @GetMapping("/venues-with-events")
    public List<VenueWithEvent> getVenuesWithEvents(
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime start,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime end) {
        return reportService.getVenuesWithEvents(start, end);
    }
}