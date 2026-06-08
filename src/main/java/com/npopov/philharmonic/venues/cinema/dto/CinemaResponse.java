package com.npopov.philharmonic.venues.cinema.dto;

import com.npopov.philharmonic.venues.venue.dto.VenueResponse;

import java.time.LocalDateTime;

public class CinemaResponse extends VenueResponse {

    private Integer screenWidthMm;
    private Integer screenHeightMm;
    private Integer screenDiagonalMm;
    private String screenAspectRatio;

    public CinemaResponse() {
    }

    public CinemaResponse(Long id, String name, String address, String city, String description, LocalDateTime createdAt, LocalDateTime updatedAt, Integer screenWidthMm, Integer screenHeightMm, Integer screenDiagonalMm, String screenAspectRatio) {
        super(id, name, address, city, description, createdAt, updatedAt);
        this.screenWidthMm = screenWidthMm;
        this.screenHeightMm = screenHeightMm;
        this.screenDiagonalMm = screenDiagonalMm;
        this.screenAspectRatio = screenAspectRatio;
    }

    public Integer getScreenWidthMm() {
        return screenWidthMm;
    }

    public void setScreenWidthMm(Integer screenWidthMm) {
        this.screenWidthMm = screenWidthMm;
    }

    public Integer getScreenHeightMm() {
        return screenHeightMm;
    }

    public void setScreenHeightMm(Integer screenHeightMm) {
        this.screenHeightMm = screenHeightMm;
    }

    public Integer getScreenDiagonalMm() {
        return screenDiagonalMm;
    }

    public void setScreenDiagonalMm(Integer screenDiagonalMm) {
        this.screenDiagonalMm = screenDiagonalMm;
    }

    public String getScreenAspectRatio() {
        return screenAspectRatio;
    }

    public void setScreenAspectRatio(String screenAspectRatio) {
        this.screenAspectRatio = screenAspectRatio;
    }
}
